package com.example.demo.exception;

import com.example.demo.common.dto.ErrorMessage;

public class ValidateException extends BusinessException {

  public ValidateException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

}
