package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.dto.request.MemberCreateDto;
import com.example.demo.service.dto.response.MemberFindDto;
import com.example.demo.service.dto.response.MemberListFindDto;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  @Transactional
  public String createMember(
      final MemberCreateDto memberCreate // 인자의 불변성을 보장
  ) {
    Member member = memberRepository.save(
        Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age()));
    return member.getId().toString();
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

  @Transactional(readOnly = true)
  public MemberListFindDto findAllMember() {

    List<MemberFindDto> members = memberRepository.findAll().stream().map(MemberFindDto::of).toList();
    return MemberListFindDto.of(members);

  }
}
