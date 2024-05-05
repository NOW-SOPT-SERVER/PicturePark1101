package com.example.carrot.service.productlike;

import com.example.carrot.model.entity.ProductLike;

public interface ProductLikeCommandService {


  public ProductLike findById(Long id);

  public Long countByProductId(Long productId);

  public Boolean actionLike(Long memberId, Long productId);
}
