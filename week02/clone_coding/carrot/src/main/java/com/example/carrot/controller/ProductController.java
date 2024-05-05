package com.example.carrot.controller;


import com.example.carrot.apiPayload.dto.SuccessMessage;
import com.example.carrot.apiPayload.dto.SuccessStatusResponse;
import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.model.dto.response.product.ProductPostResposeDTO;
import com.example.carrot.service.product.ProductCommandService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
public class ProductController {
  private final ProductCommandService productCommandService;

  @Operation(summary = "글 생성 API입니다.")
  @PostMapping("")
  public ResponseEntity<SuccessStatusResponse> postLimjang(
      @RequestBody @Valid ProductPostRequestDTO postDTO
  ){

    return ResponseEntity.status(HttpStatus.CREATED).header(
            "Location",
            productCommandService.postProduct(postDTO))
        .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
  }

}
