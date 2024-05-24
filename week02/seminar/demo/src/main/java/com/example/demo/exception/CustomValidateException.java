package com.example.demo.exception;

import com.example.demo.common.dto.ErrorMessage;
import lombok.Getter;

@Getter
public class CustomValidateException extends BusinessException {

  public CustomValidateException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

}
