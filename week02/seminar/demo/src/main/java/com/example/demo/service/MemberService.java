package com.example.demo.service;

import com.example.demo.auth.UserAuthentication;
import com.example.demo.common.dto.ErrorMessage;
import com.example.demo.common.jwt.JwtTokenProvider;
import com.example.demo.domain.Member;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.dto.member.UserJoinResponse;
import com.example.demo.service.dto.member.MemberCreateDto;
import com.example.demo.service.dto.member.MemberFindDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Lettuce.Cluster.Refresh;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final JwtTokenProvider jwtTokenProvider;

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
    return UserJoinResponse.of( memberId.toString(), accessToken, refreshToekn);

  }

  public Member findById(Long memberId) {
    return memberRepository.findById(memberId).orElseThrow(
        () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION));
  }

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
}
