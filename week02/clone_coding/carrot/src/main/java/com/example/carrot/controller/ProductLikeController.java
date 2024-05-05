package com.example.carrot.controller;

import com.example.carrot.apiPayload.dto.SuccessMessage;
import com.example.carrot.apiPayload.dto.SuccessStatusResponse;
import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.service.productlike.ProductLikeCommandService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/productlikes")
@RequiredArgsConstructor
@Validated
public class ProductLikeController {

  private final ProductLikeCommandService productLikeCommandService;

  @Operation(summary = "좋아요 추가/취소 API입니다.")
  @PostMapping("/{productId}")
  public ResponseEntity<SuccessStatusResponse> postLimjang(
    @RequestHeader(name = "memberId") Long memberId,
    @PathVariable(name = "productId") Long productId
  ){
    boolean isLiked = productLikeCommandService.actionLike(memberId, productId);
    SuccessMessage successMessage;

    if (isLiked) {
      successMessage = SuccessMessage.PRODUCTLIKE_SUCCESS_ADDED;
    } else {
      successMessage = SuccessMessage.PRODUCTLIKE_SUCCESS_REMOVED;
    }
    // ResponseEntity 생성하여 반환
    return ResponseEntity.ok(SuccessStatusResponse.of(successMessage));
  }

}
