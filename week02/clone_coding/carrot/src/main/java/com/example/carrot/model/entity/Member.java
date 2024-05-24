package com.example.carrot.model.entity;

import com.example.carrot.model.entity.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
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
public class Member extends BaseEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String phone;

  @Column(nullable = false)
  private String nickname;

  // 상품
  @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
  private List<Product> productList = new ArrayList<>();

  // 자주 쓰는 문구
  @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
  private List<FrequentlyUsedPhrases> frequentlyUsedPhrases = new ArrayList<>();

  // 활동 지역
  @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
  private List<ActiveRegion> activeRegionList = new ArrayList<>();

  // 채팅 메시지
  @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
  private List<ChatMessage> chatMessageList = new ArrayList<>();

  // 상품 좋아요
  @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
  private List<ProductLike> productLikeList = new ArrayList<>();
}
