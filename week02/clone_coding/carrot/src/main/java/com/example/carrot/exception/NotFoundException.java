package com.example.carrot.exception;

import com.example.carrot.apiPayload.dto.ErrorMessage;
import lombok.Getter;

@Getter
public class NotFoundException extends BusinessException {

  public NotFoundException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

}
