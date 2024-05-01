package com.example.demo.domain;

import com.example.demo.service.dto.blog.BlogCreateRequest;
import com.example.demo.service.dto.post.PostCreateRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  private Blog blog;


  private Post(Blog blog, String name, String content) {
    this.blog = blog;
    this.name = name;
    this.content = content;
  }

  public static Post create(Blog blog, PostCreateRequest postCreateRequest) {
    return new Post(blog, postCreateRequest.name(), postCreateRequest.content());
  }
}