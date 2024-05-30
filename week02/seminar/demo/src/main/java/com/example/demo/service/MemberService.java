package com.example.demo.service;

import com.example.demo.auth.UserAuthentication;
import com.example.demo.auth.redis.domain.Token;
import com.example.demo.common.dto.ErrorMessage;
import com.example.demo.common.jwt.JwtTokenProvider;
import com.example.demo.domain.Member;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.RedisTokenRepository;
import com.example.demo.service.dto.member.RegenerateAccessTokenRequestDto;
import com.example.demo.service.dto.member.RegenerateAccessTokenResponseDto;
import com.example.demo.service.dto.member.UserJoinResponse;
import com.example.demo.service.dto.member.MemberCreateDto;
import com.example.demo.service.dto.member.MemberFindDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final JwtTokenProvider jwtTokenProvider;
  private final RedisTokenRepository redisTokenRepository;

  @Transactional
  public UserJoinResponse createMember(
      MemberCreateDto memberCreate
  ) {
    Member member = memberRepository.save(
        Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age())
    );
    Long memberId = member.getId();
    String accessToken = jwtTokenProvider.issueAccessToken(
        UserAuthentication.createUserAuthentication(memberId)
    );
    String refreshToekn = jwtTokenProvider.issueRefreshToken(
        UserAuthentication.createUserAuthentication(memberId)
    );

    //리프레시 토큰 레디스에 저장(idx는 memberId로..)
    redisTokenRepository.save(Token.of(memberId, refreshToekn));

    return UserJoinResponse.of( memberId.toString(), accessToken, refreshToekn);

  }

  @Transactional
  public RegenerateAccessTokenResponseDto getNewAccessToken(
      RegenerateAccessTokenRequestDto regenerateAccessTokenRequestDto) {

    String refreshToken = regenerateAccessTokenRequestDto.refreshToken();

    // 리프레시 토큰이 redis에 존재하는지 확인하기. 존재하면 만료되지 않은 것임.(일정 시간 후 사라지므로)
    // 없으면 다시 로그인하라는 에러메시지 보내기
    Token token = getRefreshToken(refreshToken);

    // 존재하는 토큰이 유효한 토큰인지(제대로 된 토큰인지) 다시 검증
    jwtTokenProvider.validateToken(token.getRefreshToken());

    // 유효하다면 액세스 토큰 재발급
    String accessToken = jwtTokenProvider.issueAccessToken(
        UserAuthentication.createUserAuthentication(token.getId())
    );

    return RegenerateAccessTokenResponseDto.of(accessToken);
  }

  @Transactional(readOnly = true)
  public Member findById(Long memberId) {
    return memberRepository.findById(memberId).orElseThrow(
        () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION));
  }

  @Transactional(readOnly = true)
  public Member findMemberById(
      Long memberId
  ) {
    return memberRepository.findById(memberId).orElseThrow(
        () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
    );
  }

  @Transactional(readOnly = true) // 써도 되고 안 써도 됨.
  public MemberFindDto findMemberById2(Long memberId) {
    return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
        () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")));
  }

  @Transactional
  public void deleteMemberById(Long memberId) {
    Member member = memberRepository.findById(memberId).orElseThrow(() ->
        new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다."));
    memberRepository.delete(member);
  }

  public Token getRefreshToken(String refreshToken) {
    return redisTokenRepository.findByRefreshToken(refreshToken).orElseThrow(
        () -> new UnauthorizedException(ErrorMessage.JWT_UNAUTHORIZED_REFRESH_EXPIRED_EXCEPTION));
  }
}
