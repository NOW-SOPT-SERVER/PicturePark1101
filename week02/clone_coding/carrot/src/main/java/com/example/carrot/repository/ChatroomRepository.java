package com.example.carrot.repository;

import com.example.carrot.model.entity.Chatroom;
import com.example.carrot.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatroomRepository extends JpaRepository<Chatroom, Long> {

  @Query("SELECT COUNT(cr) FROM Chatroom cr WHERE cr.product.id = :productId")
  Long countByProductId(@Param("productId") Long productId);

}
