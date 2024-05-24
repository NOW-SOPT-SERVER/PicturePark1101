package com.example.carrot.service.category.common;


import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.Category;
import com.example.carrot.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryFinder {

  private final CategoryRepository categoryRepository;

  public Category findById(long id) {

    return categoryRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.CATEGORY_NOT_FOUND_BY_ID_EXCEPTION));
  }
}
