package com.example.carrot.repository;

import com.example.carrot.model.entity.ProductImage;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

  Optional<ProductImage> findTopByProductId(Long productId);

}
