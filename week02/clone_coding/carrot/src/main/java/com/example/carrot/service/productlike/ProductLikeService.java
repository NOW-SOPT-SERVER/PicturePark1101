package com.example.carrot.service.productlike;

public interface ProductLikeService {

  long countByProductId(long productId);

  boolean actionLike(long memberId, long productId);

}
