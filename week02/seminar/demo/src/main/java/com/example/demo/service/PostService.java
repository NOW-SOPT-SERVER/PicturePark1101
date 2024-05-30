package com.example.demo.service;

import com.example.demo.common.dto.ErrorMessage;
import com.example.demo.domain.Blog;
import com.example.demo.domain.Post;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.BlogService;
import com.example.demo.service.dto.post.PostCreateRequest;
import com.example.demo.service.dto.post.PostFindDto;
import com.example.demo.service.dto.post.PostListFindDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final BlogService blogService;

  @Transactional
  public String create(Long memberId, Long blogId, PostCreateRequest postCreateRequest)
  {
    // 요청한 사람이 블로그 소유주인지 확인, 맞으면 블로그 객체 리턴
    Blog findBlog = blogService.validateOwner(blogId, memberId);
    Post post = postRepository.save(Post.create(findBlog, postCreateRequest));

    // 블로그 글 생성하고 DB에 저장 후 생성된 id 반환
    return post.getId().toString();
  }

  public PostListFindDto findAllPost(Long blogId){
    Blog findBlog = blogService.findById(blogId);
    return PostListFindDto.of(postRepository.findByBlog(findBlog));
  }

  public Post findById(Long postId) {
    return postRepository.findById(postId).orElseThrow(
        () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
    );
  }

  public PostFindDto findPost(Long postId){

    return PostFindDto.of(findById(postId));
  }
}
