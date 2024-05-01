package com.example.carrot.apiPayload.exception.handler;

import com.example.carrot.apiPayload.code.BaseErrorCode;
import com.example.carrot.apiPayload.exception.GeneralException;

public class CategoryHandler extends GeneralException {

  public CategoryHandler(BaseErrorCode code) {
    super(code);
  }

}
