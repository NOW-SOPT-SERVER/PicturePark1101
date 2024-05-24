package com.example.demo.service.dto.post;

import com.example.demo.domain.Post;

public record PostFindDto(
    String name,

    String content

) {
  public static PostFindDto of(
      Post post
  ) {
    return new PostFindDto(post.getName(), post.getContent());
  }
}
