package com.example.carrot.service.productimage.common;

import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.ProductImage;
import com.example.carrot.repository.ProductImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductImageFinder {

  private final ProductImageRepository productImageRepository;

  public ProductImage findById(Long id) {

    return productImageRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND_BY_ID_EXCEPTION));
  }

  public String findByProductId(Long productId) {
    return  productImageRepository.findTopByProductId(productId)
        .map(ProductImage::getImageUrl)
        .orElse(""); // 만약 ProductImage가 없을 땐  빈 문자열 반환하게..
  }

}
