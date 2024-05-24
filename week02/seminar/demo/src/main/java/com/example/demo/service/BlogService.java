package com.example.demo.service;

import com.example.demo.common.dto.ErrorMessage;
import com.example.demo.domain.Blog;
import com.example.demo.domain.Member;
import com.example.demo.exception.CustomValidateException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.dto.blog.BlogCreateRequest;
import com.example.demo.service.dto.blog.BlogTitleUpdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

  public Blog findById(Long blogId) {
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

  public Blog validateOwner(Long blogId, Long requestMemberId) {

    Blog blog = findById(blogId);
    Long findMemberId = blog.getMember().getId();

    if (!requestMemberId.equals(findMemberId)) {
      throw new CustomValidateException(ErrorMessage.BLOG_UNAUTHORIZED);
    }

    return blog;
  }
}
