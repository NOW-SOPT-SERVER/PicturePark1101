package com.example.carrot.exception;

import com.example.carrot.apiPayload.dto.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
  private ErrorMessage errorMessage;

  public BusinessException(ErrorMessage errorMessage) {
    super(errorMessage.getMessage());
    this.errorMessage = errorMessage;
  }
}
