package com.example.carrot.service.product;

import com.example.carrot.model.dto.response.product.ProductListFindResponseDto;

public interface ProductQueryService {

  ProductListFindResponseDto findByRegion(String region);

}
