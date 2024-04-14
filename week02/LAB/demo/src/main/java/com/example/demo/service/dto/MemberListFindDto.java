package com.example.demo.service.dto;

import java.util.List;

public record MemberListFindDto(
    List<MemberFindDto> memberList
) {

  public static MemberListFindDto of(
      List<MemberFindDto> members
  ){
    return new MemberListFindDto(members);
  }

}
