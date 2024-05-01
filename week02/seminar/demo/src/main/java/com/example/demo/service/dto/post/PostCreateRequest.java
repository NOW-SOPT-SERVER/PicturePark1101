package com.example.demo.service.dto.post;

import jakarta.validation.constraints.NotBlank;

public record PostCreateRequest(
    @NotBlank(message = "글의 제목은 필수입니다.")
    String name,

    @NotBlank(message = "글의 내용은 필수입니다.")
    String content

){}
// name과 content가 필요함