package com.example.demo.service.dto.member;

public record RegenerateAccessTokenResponseDto(
    String accessToken
) {
  public static RegenerateAccessTokenResponseDto of(
      String accessToken

  ) {
    return new RegenerateAccessTokenResponseDto(accessToken);
  }
}
