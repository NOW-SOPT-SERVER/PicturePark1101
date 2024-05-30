package com.example.demo.service.dto.member;

public record UserJoinResponse(
    String userId,
    String accessToken,
    String refreshToekn
) {

  public static UserJoinResponse of(
      String userId,
      String accessToken,
      String refreshToekn
  ) {
    return new UserJoinResponse(userId, accessToken, refreshToekn);
  }
}
