package com.example.carrot.model.dto.response.product;

import com.example.carrot.model.entity.ProdcutImage;
import com.example.carrot.model.entity.Product;
import com.example.carrot.model.entity.ProductLike;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
import java.util.Optional;

public record ProductFindResponseDto(
    String picture,
    String title,
    LocalDateTime updatedAt,
    String price,
    int likeCnt,
    int chatroomCnt
) {
  // 사진, 제목, updatedAt, 가격, 좋아요, 채팅방 수

  public static ProductFindResponseDto of(
      ProdcutImage prodcutImage, Product product, ProductLike productLike
  ) {

    String firstPicture = product.getProdcutImageList() == null || product.getProdcutImageList().isEmpty()
        ? "" // 리스트가 null이거나 비어있다면 빈 문자열 반환
        : product.getProdcutImageList().get(0).getImageUrl(); // 첫 번째 이미지의 URL 반환

    int likeCnt = Optional.ofNullable(product.getProductLikeList())
        .map(List::size)
        .orElse(0);

    int chatroomCnt =  Optional.ofNullable(product.getChatroomList())
        .map(List::size)
        .orElse(0);

    return new ProductFindResponseDto(
        firstPicture,
        product.getTitle(),
        product.getUpdatedAt(),
        product.getPrice(),
        likeCnt,
        chatroomCnt
        );
  }
}
