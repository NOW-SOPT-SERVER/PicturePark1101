package com.example.carrot.repository;

import com.example.carrot.model.entity.Member;
import com.example.carrot.model.entity.ProductLike;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductLikeRepository extends JpaRepository<ProductLike, Long> {

  // 상품 id로 데이터 갯수를 센다
  @Query("SELECT COUNT(pl) FROM ProductLike pl WHERE pl.product.id = :productId")
  Long countByProductId(@Param("productId") Long productId);

  Optional<ProductLike> findByMemberIdAndProductId(Long productId, Long memberId);
}
