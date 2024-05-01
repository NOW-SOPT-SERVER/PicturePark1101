package com.example.demo.exception;

import com.example.demo.common.dto.ErrorMessage;
import lombok.Getter;

@Getter
public class NotFoundException extends BusinessException {

  public NotFoundException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

}


