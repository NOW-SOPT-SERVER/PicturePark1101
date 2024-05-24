package com.example.demo.exception;

import com.example.demo.common.dto.ErrorMessage;

public class UnauthorizedException extends BusinessException {
  public UnauthorizedException(ErrorMessage errorMessage) {
    super(errorMessage);
  }
}
