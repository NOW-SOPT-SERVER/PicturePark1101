package com.example.carrot.apiPayload.exception.handler;

import com.example.carrot.apiPayload.code.BaseErrorCode;
import com.example.carrot.apiPayload.exception.GeneralException;

public class ProductHandler extends GeneralException {
  public ProductHandler(BaseErrorCode code) {
    super(code);
  }
}

