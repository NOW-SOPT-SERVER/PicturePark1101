package com.example.carrot.apiPayload.exception.handler;

import com.example.carrot.apiPayload.code.BaseErrorCode;
import com.example.carrot.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
