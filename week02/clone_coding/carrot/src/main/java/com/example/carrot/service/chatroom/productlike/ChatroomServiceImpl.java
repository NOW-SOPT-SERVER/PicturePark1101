package com.example.carrot.service.chatroom.productlike;


import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.Chatroom;
import com.example.carrot.model.entity.ProductLike;
import com.example.carrot.repository.ChatroomRepository;
import com.example.carrot.repository.ProductLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatroomServiceImpl implements ChatroomService {

  private final ChatroomRepository chatroomRepository;

  public Chatroom findById(Long id) {

    return chatroomRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.PRODUCTLIKE_NOT_FOUND_BY_ID_EXCEPTION));
  }

  public Long countByProductId(Long productId) {
    return chatroomRepository.countByProductId(productId);
  }


}
