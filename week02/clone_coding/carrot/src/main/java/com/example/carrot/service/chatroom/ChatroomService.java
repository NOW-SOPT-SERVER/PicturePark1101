package com.example.carrot.service.chatroom;

import com.example.carrot.model.entity.Chatroom;
import com.example.carrot.model.entity.ProductLike;

public interface ChatroomService {

  Long countByProductId(Long productId);

}
