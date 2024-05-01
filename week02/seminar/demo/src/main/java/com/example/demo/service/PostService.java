package com.example.demo.service;


import com.example.demo.common.dto.ErrorMessage;
import com.example.demo.domain.Blog;
import com.example.demo.domain.Member;
import com.example.demo.domain.Post;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.dto.post.PostCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final MemberService memberService;
  private final BlogService blogService;

  @Transactional
  public String create(Long memberId, Long blogId, PostCreateRequest postCreateRequest)
  {
    // blog 찾기
    Blog blog = blogService.findById(blogId);
    Long findMemberId = blog.getMember().getId();

    // 요청한 사람이 블로그 소유주인지 확인
    blogService.validateOwner(memberId, findMemberId);

    Post post = postRepository.save(Post.create(blog, postCreateRequest));
    // 블로그 글 생성하고 DB에 저장 후 생성된 id 반환
    return post.getId().toString();
  }
}
