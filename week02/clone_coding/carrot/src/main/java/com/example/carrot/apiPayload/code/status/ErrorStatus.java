package com.example.carrot.apiPayload.code.status;

import com.example.carrot.apiPayload.code.BaseErrorCode;
import com.example.carrot.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 판매글 관련(Product)
    _PRODUCT_BAD_REQUEST_TRANSACTION_METHOD(HttpStatus.BAD_REQUEST,"PRODUCT400","해당 거래 방식은 존재하지 않습니다. 다시 확인부탁드립니다."),
    _PRODUCT_BAD_REQUEST_CATEGROY(HttpStatus.BAD_REQUEST,"PRODUCT400","해당 카테고리 ID는 존재하지 않습니다. 다시 확인부탁드립니다."),

    // member..
    _MEMBER_NOT_FIND(HttpStatus.UNAUTHORIZED,"MEMBER401","해당 회원은 존재하지 않습니다."),
    _CATEGORY_NOT_FIND(HttpStatus.BAD_REQUEST,"CATEGORY400","해당 카테고리 ID는 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
