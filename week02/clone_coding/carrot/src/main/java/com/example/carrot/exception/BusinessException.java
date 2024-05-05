package com.example.carrot.exception;

import lombok.Getter;
import org.springdoc.api.ErrorMessage;

@Getter
public class BusinessException extends RuntimeException{
  private ErrorMessage errorMessage;

  public BusinessException(ErrorMessage errorMessage) {
    super(errorMessage.getMessage());
    this.errorMessage = errorMessage;
  }
}
