package com.example.carrot.service.chatroom.common;

import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.Chatroom;
import com.example.carrot.repository.ChatroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatRoomFinder {

  private final ChatroomRepository chatroomRepository;

  public Chatroom findById(long id) {

    return chatroomRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.PRODUCTLIKE_NOT_FOUND_BY_ID_EXCEPTION));
  }
}
