package com.example.carrot.apiPayload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

  PRODUCT_POST_CREATE_SUCCESS(HttpStatus.CREATED.value(), "포스트 생성이 완료되었습니다."),
  PRODUCT_POST_FIND_SUCCESS(HttpStatus.OK.value(), "지역별 조회 완료되었습니다.");

  private final int status;
  private final String message;

}
