package com.example.demo.controller;

import com.example.demo.auth.PrincipalHandler;
import com.example.demo.common.dto.SuccessMessage;
import com.example.demo.common.dto.SuccessStatusResponse;
import com.example.demo.service.BlogService;
import com.example.demo.service.dto.blog.BlogCreateRequest;
import com.example.demo.service.dto.blog.BlogTitleUpdateRequest;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

  private final BlogService blogService;

  private final PrincipalHandler principalHandler;

  @PostMapping("")
  public ResponseEntity createBlog(
      @ModelAttribute BlogCreateRequest blogCreateRequest
  ) {
    return ResponseEntity.created(URI.create(blogService.create(
        principalHandler.getUserIdFromPrincipal(), blogCreateRequest))).build();
  }

  @PatchMapping("/{blogId}/title")
  public ResponseEntity updateBlogTitle(
      @PathVariable Long blogId,
      @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
  ) {
    blogService.updateTitle(blogId, blogTitleUpdateRequest);
    return ResponseEntity.noContent().build();
  }
}
