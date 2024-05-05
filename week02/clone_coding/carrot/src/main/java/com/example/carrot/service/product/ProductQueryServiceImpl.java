package com.example.carrot.service.product;


import com.example.carrot.model.dto.response.product.ProductFindResponseDto;
import com.example.carrot.model.dto.response.product.ProductListFindResponseDto;
import com.example.carrot.model.entity.Product;
import com.example.carrot.model.entity.ProductImage;
import com.example.carrot.model.entity.ProductLike;
import com.example.carrot.repository.ChatroomRepository;
import com.example.carrot.repository.ProductRepository;
import com.example.carrot.service.productimage.ProductImageService;
import com.example.carrot.service.productlike.ProductLikeService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService{

  private final ProductRepository productRepository;
  private final ProductImageService productImageService;
  private final ProductLikeService productLikeService;
  private final ChatroomRepository chatroomRepository;

  public ProductListFindResponseDto findByRegion(String region){

    List<ProductFindResponseDto> productFindResponseDtoList = productRepository.findByRegionName(region)
        .stream()
        .map(product -> {
          String productImage = productImageService.findByProductId(product.getId());
          Long cntLike = productLikeService.countByProductId(product.getId());
          Long cntChatroom = chatroomRepository.countByProductId(product.getId());

          return ProductFindResponseDto.of(product, productImage, cntLike, cntChatroom);
        }).toList();

    return new ProductListFindResponseDto(productFindResponseDtoList);
  }

}
