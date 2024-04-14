package com.example.demo.service.dto.request;


import com.example.demo.domain.enums.Part;

public record MemberCreateDto(
    String name,
    Part part,
    int age
) {
}
