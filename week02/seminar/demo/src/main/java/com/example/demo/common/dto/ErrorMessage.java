package com.example.demo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

  MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
  BLOG_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 없습니다."),
  BLOG_UNAUTHORIZED(HttpStatus.NOT_FOUND.value(), "해당 블로그의 소유자가 아닙니다."),
  POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 포스트가 없습니다."),
  JWT_UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "사용자의 로그인 검증을 실패했습니다."),
  ;

  private final int status;
  private final String message;
}
