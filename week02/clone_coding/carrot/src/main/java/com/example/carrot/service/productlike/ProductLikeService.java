package com.example.carrot.service.productlike;

import com.example.carrot.model.entity.ProductImage;
import com.example.carrot.model.entity.ProductLike;
import com.example.carrot.repository.ProductImageRepository;
import com.example.carrot.repository.ProductLikeRepository;

public interface ProductLikeService {


  public ProductLike findById(Long id);

}
