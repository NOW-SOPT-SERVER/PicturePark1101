package com.example.carrot.service.region.common;

import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.Region;
import com.example.carrot.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegionFinder {

  private final RegionRepository regionRepository;

  public Region findById(Long id) {

    return regionRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.PRODUCTLIKE_NOT_FOUND_BY_ID_EXCEPTION));
  }
}
