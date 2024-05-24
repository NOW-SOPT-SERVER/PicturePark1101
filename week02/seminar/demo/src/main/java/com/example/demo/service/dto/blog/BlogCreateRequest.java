package com.example.demo.service.dto.blog;

import org.springframework.web.multipart.MultipartFile;

public record BlogCreateRequest(
    String title,
    String description,
    MultipartFile image
) {
}
