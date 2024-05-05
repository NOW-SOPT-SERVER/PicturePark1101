package com.example.carrot.apiPayload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

  POST_CREATE_SUCCESS(HttpStatus.CREATED.value(), "포스트 생성이 완료되었습니다.");

  private final int status;
  private final String message;

}
