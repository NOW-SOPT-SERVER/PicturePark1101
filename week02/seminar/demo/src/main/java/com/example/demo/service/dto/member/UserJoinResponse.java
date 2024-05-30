package com.example.demo.service.dto.member;

public record UserJoinResponse(
    String accessToken,
    String refreshToekn,
    String userId
) {

  public static UserJoinResponse of(
      String accessToken,
      String refreshToekn,
      String userId
  ) {
    return new UserJoinResponse(accessToken, refreshToekn, userId);
  }
}
