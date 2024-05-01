package com.example.demo.service;

import com.example.demo.common.dto.ErrorMessage;
import com.example.demo.domain.Blog;
import com.example.demo.domain.Member;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.dto.blog.BlogCreateRequest;
import com.example.demo.service.dto.blog.BlogTitleUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {
  private final BlogRepository blogRepository;
  private final MemberService memberService;


  public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
    Member member = memberService.findById(memberId);
    Blog blog = blogRepository.save(Blog.create(member, blogCreateRequest));
    return blog.getId().toString();
  }

  private Blog findById(Long blogId) {
    return blogRepository.findById(blogId).orElseThrow(
        () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND)
    );
  }

  @Transactional
  public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
    Blog blog = findById(blogId);
    blog.updateTitle(blogTitleUpdateRequest);
    //    blogRepository.save(blog); 이렇게 해도 됨.
  }
}
