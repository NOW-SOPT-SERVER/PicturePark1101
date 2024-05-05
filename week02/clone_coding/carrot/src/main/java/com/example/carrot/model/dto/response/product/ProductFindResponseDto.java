package com.example.carrot.model.dto.response.product;

import com.example.carrot.model.entity.ProductImage;
import com.example.carrot.model.entity.Product;
import com.example.carrot.model.entity.ProductLike;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

public record ProductFindResponseDto(
    String picture,
    String title,
    LocalDateTime updatedAt,
    String price,
    Long likeCnt,
    Long chatroomCnt
) {
  // 사진, 제목, updatedAt, 가격, 좋아요, 채팅방 수

  public static ProductFindResponseDto of(
      Product product, String prodcutImage, Long cntLike, Long cntChatroom
  ) {

    return new ProductFindResponseDto(
        prodcutImage,
        product.getTitle(),
        product.getUpdatedAt(),
        product.getPrice(),
        cntLike,
        cntChatroom
        );
  }
}
