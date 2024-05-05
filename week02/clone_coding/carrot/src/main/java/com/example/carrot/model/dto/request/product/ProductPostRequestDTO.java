package com.example.carrot.model.dto.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductPostRequestDTO(

    @NotNull(message = "memberId가 비었습니다.")
    Long memberId,

    @NotNull(message = "categoryId가 비었습니다.")
    Long categoryId,

    @NotNull(message = "regionId가 비었습니다.")
    Long regionId,

    @NotBlank(message = "null 혹은 공백이 전달되었습니다.")
    String title,

    @NotBlank(message = "null 혹은 공백이 전달되었습니다.")
    // 거래 방식
    String transactionMethod,

    // 거래 선호 장소 닉네임(사용자가 입력해야함)
    String regionNickname,
    // 내용
    @NotBlank(message = "null 혹은 공백이 전달되었습니다.")
    String content,

    @NotBlank(message = "null 혹은 공백이 전달되었습니다.")
    String price,

    //가격 제안 받을 건지
    @NotNull
    Boolean isEnabledOffer
) {


}
