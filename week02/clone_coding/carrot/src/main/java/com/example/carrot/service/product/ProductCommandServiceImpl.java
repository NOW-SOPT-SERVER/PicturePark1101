package com.example.carrot.service.product;

import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.converter.product.ProductPostConverter;
import com.example.carrot.exception.NotFoundException;
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

  public String postProduct(ProductPostRequestDTO postRequestDTO) {

    Member findMember = memberRepository.findById(postRequestDTO.memberId())
        .orElseThrow(() -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION));

    Category findCategory = categoryRepository.findById(postRequestDTO.categoryId())
        .orElseThrow(() -> new NotFoundException(ErrorMessage.CATEGORY_NOT_FOUND_BY_ID_EXCEPTION));

    Product newProduct = ProductPostConverter.toProduct(findMember, findCategory, postRequestDTO);
    productRepository.save(newProduct);
    return newProduct.getId().toString();
  }


}
