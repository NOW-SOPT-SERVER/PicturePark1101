package com.example.carrot.service.chatroom.productlike;

import com.example.carrot.model.entity.Chatroom;
import com.example.carrot.model.entity.ProductLike;

public interface ChatroomService {


  public Chatroom findById(Long id);

  public Long countByProductId(Long productId);

}
