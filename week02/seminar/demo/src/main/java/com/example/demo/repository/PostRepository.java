package com.example.demo.repository;

import com.example.demo.domain.Blog;
import com.example.demo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
