package com.example.carrot.model.dto.response.product;

import com.example.carrot.model.entity.Product;

public record ProductPostResposeDTO(
    Long postId
) {
  public static ProductPostResposeDTO of(
      Product product
  ) {
    return new ProductPostResposeDTO(product.getId());
  }
}
