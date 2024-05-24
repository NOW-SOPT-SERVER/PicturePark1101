package com.example.demo.domain;

import com.example.demo.service.dto.blog.BlogCreateRequest;
import com.example.demo.service.dto.blog.BlogTitleUpdateRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Blog extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  private Member member;

  @Column(length = 200)
  private String title;

  private String description;

  private Blog(Member member, String title, String description) {
    this.member = member;
    this.title = title;
    this.description = description;
  }

  public static Blog create(Member member, BlogCreateRequest blogCreateRequest) {
    return new Blog(member, blogCreateRequest.title(), blogCreateRequest.description());
  }

  public void updateTitle(BlogTitleUpdateRequest blogTitleUpdateRequest) {
    this.title = blogTitleUpdateRequest.title();
  }
}
