package com.example.carrot.controller;


import com.example.carrot.apiPayload.dto.SuccessMessage;
import com.example.carrot.apiPayload.dto.SuccessStatusResponse;
import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.service.product.ProductCommandService;
import com.example.carrot.service.product.ProductQueryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

  private final ProductCommandService productCommandService;
  private final ProductQueryService productQueryService;

  @Operation(summary = "글 생성 API입니다.")
  @PostMapping
  public ResponseEntity<SuccessStatusResponse> postLimjang(
      @RequestBody @Valid ProductPostRequestDTO postDTO
  ){

    return ResponseEntity.created(
        URI.create(productCommandService.postProduct(postDTO)))
        .body(SuccessStatusResponse.of(SuccessMessage.PRODUCT_POST_CREATE_SUCCESS));
  }

  @Operation(summary = "지역별 상품 LIST API입니다.")
  @GetMapping("/{regionId}")
  public ResponseEntity<SuccessStatusResponse> getPostsByRegion  (
      @PathVariable(name = "regionId") Long regionId
  ){

    return ResponseEntity.ok(SuccessStatusResponse.of(
        SuccessMessage.PRODUCT_POST_FIND_SUCCESS,
        productQueryService.findByRegion(regionId)));
  }

}
