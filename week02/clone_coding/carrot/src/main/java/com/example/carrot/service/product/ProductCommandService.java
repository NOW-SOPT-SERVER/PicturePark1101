package com.example.carrot.service.product;

import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.model.entity.Product;

public interface ProductCommandService {

  public String postProduct(ProductPostRequestDTO postRequestDTO);

}
