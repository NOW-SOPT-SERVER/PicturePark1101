package com.example.demo.service.dto.member;

public record RegenerateAccessTokenDto(
    String accessToken
) {
  public static RegenerateAccessTokenDto of(
      String accessToken

  ) {
    return new RegenerateAccessTokenDto(accessToken);
  }
}
