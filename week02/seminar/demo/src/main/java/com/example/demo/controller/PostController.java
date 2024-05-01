package com.example.demo.controller;


import com.example.demo.common.dto.SuccessMessage;
import com.example.demo.common.dto.SuccessStatusResponse;
import com.example.demo.service.PostService;
import com.example.demo.service.dto.post.PostCreateRequest;
import com.example.demo.service.dto.post.PostFindDto;
import com.example.demo.service.dto.post.PostListFindDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("post/{blogId}")
  public ResponseEntity<SuccessStatusResponse> findPostList(
      @RequestHeader(name = "memberId") Long memberId,
      @PathVariable(name = "blogId") Long blogId
      ) {

    PostListFindDto postList = postService.findAllPost(memberId, blogId);

    return ResponseEntity.ok(SuccessStatusResponse.of(
        SuccessMessage.POST_FIND_SUCCESS,
        postList
    ));

  }

  @GetMapping("post/{blogId}/{postId}")
  public ResponseEntity<SuccessStatusResponse> findPost(
      @RequestHeader(name = "memberId") Long memberId,
      @PathVariable(name = "blogId") Long blogId,
      @PathVariable(name = "postId") Long postId
  ) {

    PostFindDto post = postService.findPost(memberId, blogId, postId);

    return ResponseEntity.ok(SuccessStatusResponse.of(
        SuccessMessage.POST_FIND_SUCCESS,
        post
    ));

  }
}
