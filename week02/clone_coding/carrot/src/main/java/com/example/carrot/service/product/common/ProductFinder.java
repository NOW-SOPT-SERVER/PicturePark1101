package com.example.carrot.service.product.common;


import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.Product;
import com.example.carrot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFinder {

  private final ProductRepository productRepository;

  public Product findById(Long id) {
    return productRepository.findById(id)
        .orElseThrow(
            () -> new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND_BY_ID_EXCEPTION));
  }
}
