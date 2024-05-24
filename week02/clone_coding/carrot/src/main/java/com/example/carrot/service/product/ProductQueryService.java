package com.example.carrot.service.product;

import com.example.carrot.model.dto.response.product.ProductListFindResponseDto;
import com.example.carrot.model.entity.Product;

public interface ProductQueryService {

  public ProductListFindResponseDto findByRegion(Long regionId);

  public Product findById(Long id);

}
