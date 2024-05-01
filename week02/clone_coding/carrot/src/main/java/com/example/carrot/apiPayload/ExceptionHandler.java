package com.example.carrot.apiPayload;


import com.example.carrot.apiPayload.code.BaseErrorCode;
import com.example.carrot.apiPayload.exception.GeneralException;

public class ExceptionHandler extends GeneralException {
    public ExceptionHandler(BaseErrorCode code) {
        super(code);
    }
}
