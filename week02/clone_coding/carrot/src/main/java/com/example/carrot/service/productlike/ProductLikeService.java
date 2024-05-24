package com.example.carrot.service.productlike;

public interface ProductLikeService {

  Long countByProductId(Long productId);

  Boolean actionLike(Long memberId, Long productId);

}
