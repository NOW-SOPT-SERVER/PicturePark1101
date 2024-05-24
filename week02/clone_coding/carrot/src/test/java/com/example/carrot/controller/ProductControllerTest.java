package com.example.carrot.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.repository.ProductRepository;
import com.example.carrot.service.product.ProductCommandService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private ProductCommandService productCommandService;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ObjectMapper objectMapper;

  private ProductPostRequestDTO postRequestDTO;

  @BeforeEach
  void setUp() {
    postRequestDTO = new ProductPostRequestDTO(
        1L, 1L, 1L,
        "마우스팝니다", "SELL", "우리집", "마우스팔아요 에눌 거절",
        "100000", true
        );
  }

  @Nested
  class createBlog {
    @Test
    @DisplayName("판매글 생성 성공 테스트")
    public void createProductSuccess() throws Exception {

      // given
      when(productCommandService.postProduct(any(ProductPostRequestDTO.class)))
          .thenReturn("/api/v1/posts");

      String request = objectMapper.writeValueAsString(postRequestDTO);

      //when, then
      mockMvc.perform(
              post("/api/v1/posts")
                  .content(request)
                  .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isCreated()) //생성 실패 시나리오로 NotFound가 돌아오는 상황을 테스트
          .andDo(print()); // 끝난 후 모든 결과를 출력
      //then?

    }
  }
}
