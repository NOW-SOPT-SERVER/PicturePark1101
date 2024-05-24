package com.example.carrot.service.product;


import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.dto.response.product.ProductFindResponseDto;
import com.example.carrot.model.dto.response.product.ProductListFindResponseDto;
import com.example.carrot.model.entity.Product;
import com.example.carrot.repository.ProductRepository;
import com.example.carrot.service.chatroom.ChatroomService;
import com.example.carrot.service.productimage.ProductImageService;
import com.example.carrot.service.productimage.common.ProductImageFinder;
import com.example.carrot.service.productlike.ProductLikeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService{

  private final ProductRepository productRepository;
  private final ProductImageFinder productImageFinder;
  private final ProductLikeService productLikeService;
  private final ChatroomService chatroomService;

  public ProductListFindResponseDto findByRegion(Long regionId){

    List<Product> products = productRepository.findByRegionId(regionId);

    if (products.isEmpty()) {
      throw new NotFoundException(ErrorMessage.REGION_NOT_FOUND_BY_ID_EXCEPTION);
    }

    List<ProductFindResponseDto> productFindResponseDtoList = products.stream()
        .map(product -> {
          String productImage = productImageFinder.findByProductId(product.getId());
          Long cntLike = productLikeService.countByProductId(product.getId());
          Long cntChatroom = chatroomService.countByProductId(product.getId());

          return ProductFindResponseDto.of(product, productImage, cntLike, cntChatroom);
        }).toList();

    return new ProductListFindResponseDto(productFindResponseDtoList);
  }
}
