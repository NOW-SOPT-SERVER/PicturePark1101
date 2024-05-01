package com.example.carrot.controller.product;


import com.example.carrot.apiPayload.ApiResponse;
import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.model.dto.response.product.ProductPostResposeDTO;
import com.example.carrot.service.product.ProductCommandService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
  public ApiResponse<ProductPostResposeDTO> postLimjang(
      @RequestBody @Valid ProductPostRequestDTO postDTO
  ){

    return ApiResponse.onSuccess(ProductPostResposeDTO.of(productCommandService.postProduct(postDTO)));
  }


}
