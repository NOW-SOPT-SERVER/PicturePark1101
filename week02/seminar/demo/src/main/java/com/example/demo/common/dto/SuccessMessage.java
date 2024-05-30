package com.example.demo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

  BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 생성이 완료되었습니다."),
  POST_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 포스트 생성이 완료되었습니다."),
  POST_FIND_SUCCESS(HttpStatus.OK.value(), "블로그 포스트 조회에 성공했습니다."),
  MEMBER_SING_UP_SUCCESS(HttpStatus.OK.value(), "회원가입에 성공했습니다."),
  ACCESS_TOKEN_REGENERATE_SUCCESS(HttpStatus.OK.value(), "액세스 토큰 재발급에 성공했습니다.")
  ;

  private final int status;
  private final String message;

}
