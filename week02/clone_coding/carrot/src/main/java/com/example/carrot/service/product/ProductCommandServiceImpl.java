package com.example.carrot.service.product;

import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.converter.product.ProductPostConverter;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.model.entity.Category;
import com.example.carrot.model.entity.Member;
import com.example.carrot.model.entity.Product;
import com.example.carrot.model.entity.Region;
import com.example.carrot.repository.CategoryRepository;
import com.example.carrot.repository.MemberRepository;
import com.example.carrot.repository.ProductRepository;
import com.example.carrot.repository.RegionRepository;
import com.example.carrot.service.member.MemberService;
import com.example.carrot.service.region.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {

  private final ProductRepository productRepository;
  private final RegionService regionService;
  private final CategoryRepository categoryRepository;
  private final MemberService memberService;

  @Transactional
  public String postProduct(ProductPostRequestDTO postRequestDTO) {

    Member findMember = memberService.findById(postRequestDTO.memberId());

    // 일단 냅두기.. category와 Regiond의 service를 따로 생성할 필요가 있는지..
    Category findCategory = categoryRepository.findById(postRequestDTO.categoryId())
        .orElseThrow(() -> new NotFoundException(ErrorMessage.CATEGORY_NOT_FOUND_BY_ID_EXCEPTION));

    Region findRegion = regionService.findById(postRequestDTO.regionId());

    Product newProduct = ProductPostConverter.toProduct(findMember, findRegion, findCategory, postRequestDTO);

    productRepository.save(newProduct);
    return newProduct.getId().toString();
  }


}
