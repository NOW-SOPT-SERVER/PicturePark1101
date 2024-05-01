package com.example.carrot.apiPayload.exception.handler;

import com.example.carrot.apiPayload.code.BaseErrorCode;
import com.example.carrot.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {

  public MemberHandler(BaseErrorCode code) {
    super(code);
  }

}
