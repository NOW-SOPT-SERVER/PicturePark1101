package com.example.carrot.service.product;

import com.example.carrot.model.dto.response.product.ProductListFindResponseDto;
import com.example.carrot.model.entity.Product;

public interface ProductQueryService {

  ProductListFindResponseDto findByRegion(Long regionId);
}
