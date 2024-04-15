package com.example.carrot.model.entity;


import com.example.carrot.model.entity.common.BaseEntity;
import com.example.carrot.model.enums.TransactionMethod;
import com.example.carrot.model.enums.TransactionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product extends BaseEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long memberId;

  private Long regionId;

  private Long categoryId;

  private String title;

  private TransactionMethod transactionMethod;

  private String price;

  private TransactionStatus transactionStatus;

  private String content;

  private boolean isPost;


}
