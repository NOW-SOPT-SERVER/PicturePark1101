package com.example.carrot.service.productlike;


import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.ProductImage;
import com.example.carrot.model.entity.ProductLike;
import com.example.carrot.repository.ProductLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductLikeServiceImpl implements ProductLikeService {

  private final ProductLikeRepository productLikeRepository;

  public ProductLike findById(Long id) {

    return productLikeRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.PRODUCTLIKE_NOT_FOUND_BY_ID_EXCEPTION));
  }

}
