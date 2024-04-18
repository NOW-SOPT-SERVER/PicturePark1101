package com.example.demo.service.dto;


import com.example.demo.domain.Member;
import com.example.demo.domain.enums.Part;

public record MemberFindDto(
    String name,
    Part part,
    int age
) {


  // DTO는 말그대로 Data Transfer이기때문에 어떤 로직도 들어가면 안된다.
  public static MemberFindDto of(
      Member member
  ) {
    return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
  }
}
