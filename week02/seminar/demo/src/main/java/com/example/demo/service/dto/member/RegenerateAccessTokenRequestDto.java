package com.example.demo.service.dto.member;

import jakarta.validation.constraints.NotBlank;

public record RegenerateAccessTokenRequestDto(
    @NotBlank(message = "refresh token이 비었거나 null일 수 없습니다.")
      String refreshToken
  ) {
}
