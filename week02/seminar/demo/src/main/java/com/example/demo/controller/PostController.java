package com.example.demo.controller;


import com.example.demo.common.dto.SuccessMessage;
import com.example.demo.common.dto.SuccessStatusResponse;
import com.example.demo.domain.Blog;
import com.example.demo.service.MemberService;
import com.example.demo.service.PostService;
import com.example.demo.service.dto.blog.BlogCreateRequest;
import com.example.demo.service.dto.member.MemberCreateDto;
import com.example.demo.service.dto.post.PostCreateRequest;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1") // 버전1의 api를 만든다.
public class PostController {

  private final PostService postService;

  @PostMapping("post/{blogId}")
  public ResponseEntity<SuccessStatusResponse> publishPost(
      @RequestHeader(name = "memberId") Long memberId,
      @PathVariable(name = "blogId") Long blogId,
      @Valid @RequestBody PostCreateRequest postCreateRequest
  ) {


    // Location은 생성된 리소스의 위치를 나타낸다. 이 코드의 경우 생성된 post의 id
    return ResponseEntity.status(HttpStatus.CREATED).header(
            "Location",
            postService.create(memberId, blogId, postCreateRequest))
      .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
  }

}
