package com.example.carrot.model.entity;

import com.example.carrot.model.entity.common.BaseEntity;
import com.example.carrot.model.enums.TransactionMethod;
import com.example.carrot.model.enums.TransactionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class ProductLike extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  public static ProductLike create(Member member, Product product) {

    return ProductLike.builder()
        .member(member)
        .product(product)
        .build();
  }

  @Builder
  private ProductLike(Member member, Product product) {
    this.member = member;
    this.product = product;
  }
}
