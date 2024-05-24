package com.example.carrot.service.productimage;

import com.example.carrot.model.entity.ProductImage;

public interface ProductImageService {

  public ProductImage findById(Long id);

  public String findByProductId(Long productId);

}
