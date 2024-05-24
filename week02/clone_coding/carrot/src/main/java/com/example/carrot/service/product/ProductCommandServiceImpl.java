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
import com.example.carrot.service.category.common.CategoryFinder;
import com.example.carrot.service.member.MemberService;
import com.example.carrot.service.member.common.MemberFinder;
import com.example.carrot.service.region.RegionService;
import com.example.carrot.service.region.common.RegionFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCommandServiceImpl implements ProductCommandService {

  private final ProductRepository productRepository;
  private final CategoryFinder categoryFinder;
  private final MemberFinder memberFinder;
  private final RegionFinder regionFinder;

  @Transactional
  public String postProduct(ProductPostRequestDTO postRequestDTO) {

    Member findMember = memberFinder.findById(postRequestDTO.memberId());

    Category findCategory = categoryFinder.findById(postRequestDTO.categoryId());
    Region findRegion = regionFinder.findById(postRequestDTO.regionId());
    Product newProduct = ProductPostConverter.toProduct(findMember, findRegion, findCategory,
        postRequestDTO);

    productRepository.save(newProduct);
    return newProduct.getId().toString();
  }
}
