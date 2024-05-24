package com.example.carrot.service.member.common;

import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.Member;
import com.example.carrot.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberFinder {

  private final MemberRepository memberRepository;

  public Member findById(long id) {

    return memberRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION));
  }
}
