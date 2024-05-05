package com.example.carrot.service.region;


import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.Chatroom;
import com.example.carrot.model.entity.Region;
import com.example.carrot.repository.ChatroomRepository;
import com.example.carrot.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

  private final RegionRepository regionRepository;

  public Region findById(Long id) {

    return regionRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.PRODUCTLIKE_NOT_FOUND_BY_ID_EXCEPTION));
  }

}
