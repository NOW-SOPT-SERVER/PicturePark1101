package com.example.carrot.service.chatroom;

import com.example.carrot.repository.ChatroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatroomServiceImpl implements ChatroomService {

  private final ChatroomRepository chatroomRepository;

  public Long countByProductId(Long productId) {
    return chatroomRepository.countByProductId(productId);
  }
}
