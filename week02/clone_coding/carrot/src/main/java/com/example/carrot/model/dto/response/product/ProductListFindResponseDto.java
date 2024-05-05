package com.example.carrot.model.dto.response.product;

import java.util.List;

public record ProductListFindResponseDto(
    List<ProductFindResponseDto> productList)
{
}
