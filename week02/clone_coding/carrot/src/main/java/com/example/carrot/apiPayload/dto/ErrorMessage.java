package com.example.carrot.apiPayload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

  MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
  CATEGORY_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 카테고리가 존재하지 않습니다."),
  TRANSACTION_METHOD_NOT_VALIDATED(HttpStatus.NOT_FOUND.value(), "해당 거래방식은 지정된 방식이 아닙니다."),
  PRODUCT_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 상품이 존재하지 않습니다."),
  PRODUCTIMAGE_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 상품 사진이 존재하지 않습니다."),
  PRODUCTLIKE_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 좋아요 글이 존재하지 않습니다.");
  ;

  private final int status;
  private final String message;
}
