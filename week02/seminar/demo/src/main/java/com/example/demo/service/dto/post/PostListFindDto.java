package com.example.demo.service.dto.post;

import com.example.demo.domain.Post;
import java.util.List;

public record PostListFindDto(
    List<PostFindDto> postList

) {
  public static PostListFindDto of(
      List<Post> posts
  ) {
    List<PostFindDto> postFindDtoList = posts.stream()
        .map(PostFindDto::of)
        .toList();
    return new PostListFindDto(postFindDtoList);
  }
}

