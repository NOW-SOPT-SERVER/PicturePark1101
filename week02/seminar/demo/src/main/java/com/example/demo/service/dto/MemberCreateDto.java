package com.example.demo.service.dto;

import com.example.seminar.domain.enums.Part;

public record MemberCreateDto(
    String name,
    Part part,
    int age
) {
}
