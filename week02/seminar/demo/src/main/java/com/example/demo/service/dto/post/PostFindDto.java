package com.example.demo.service.dto.post;

import com.example.demo.domain.Member;
import com.example.demo.domain.Post;
import com.example.demo.service.dto.member.MemberFindDto;
import jakarta.validation.constraints.NotBlank;

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
