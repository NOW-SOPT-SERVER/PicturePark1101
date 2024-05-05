package com.example.carrot.repository;

import com.example.carrot.model.entity.Member;
import com.example.carrot.model.entity.ProductLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLikeRepository extends JpaRepository<ProductLike, Long> {

}
