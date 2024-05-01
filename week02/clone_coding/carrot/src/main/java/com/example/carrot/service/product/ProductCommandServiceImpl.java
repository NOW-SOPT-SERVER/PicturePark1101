package com.example.carrot.service.product;

import com.example.carrot.apiPayload.code.status.ErrorStatus;
import com.example.carrot.apiPayload.exception.handler.CategoryHandler;
import com.example.carrot.apiPayload.exception.handler.MemberHandler;
import com.example.carrot.converter.product.ProductPostConverter;
import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.model.entity.Category;
import com.example.carrot.model.entity.Member;
import com.example.carrot.model.entity.Product;
import com.example.carrot.repository.CategoryRepository;
import com.example.carrot.repository.MemberRepository;
import com.example.carrot.repository.ProductRepository;
import com.example.carrot.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {


  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final MemberRepository memberRepository;
  private final RegionRepository regionRepository;

  public Product postProduct(ProductPostRequestDTO postRequestDTO) {

    Member findMember = memberRepository.findById(postRequestDTO.memberId())
        .orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FIND));

    Category findCategory = categoryRepository.findById(postRequestDTO.categoryId())
        .orElseThrow(() -> new CategoryHandler(ErrorStatus._CATEGORY_NOT_FIND));

    Product newProduct = ProductPostConverter.toProduct(findMember, findCategory, postRequestDTO);
    productRepository.save(newProduct);
    return newProduct;
  }


}
