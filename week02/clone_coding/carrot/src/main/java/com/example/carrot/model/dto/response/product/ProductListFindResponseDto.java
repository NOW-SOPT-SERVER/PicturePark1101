package com.example.carrot.model.dto.response.product;

import com.example.carrot.model.entity.Product;
import com.example.carrot.model.entity.ProductImage;
import com.example.carrot.model.entity.ProductLike;
import java.util.List;
import java.util.Optional;

public record ProductListFindResponseDto(
    List<ProductFindResponseDto> productList)
{

  public static ProductListFindResponseDto of(
      List<ProductFindResponseDto> productFindResponseDtoList
  ) {
    return new ProductListFindResponseDto(productFindResponseDtoList);
  }
}
