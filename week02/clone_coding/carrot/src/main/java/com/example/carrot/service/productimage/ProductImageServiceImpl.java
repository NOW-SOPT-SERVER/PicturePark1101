package com.example.carrot.service.productimage;


import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.ProductImage;
import com.example.carrot.repository.ProductImageRepository;
import com.example.carrot.repository.ProductLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

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
