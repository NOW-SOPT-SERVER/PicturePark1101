package com.example.carrot.model.entity;


import com.example.carrot.model.entity.common.BaseEntity;
import com.example.carrot.model.enums.TransactionMethod;
import com.example.carrot.model.enums.TransactionStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Product extends BaseEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "region_id")
  private Region region;

  // 거래 희망 장소 nickname(사용자가 입력해야함)
  private String regionNickname;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @Column(nullable = false)
  private String title;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TransactionMethod transactionMethod;

  @Column(nullable = false)
  private String price;

  // 가격 제안 받을 건지
  @Column(nullable = false)
  private Boolean isEnabledOffer;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TransactionStatus transactionStatus;

  @Column(nullable = false)
  private String content;

  // 게시된 글인지(임시저장 여부 판단)
  @Column(nullable = false)
  private Boolean isPost;

  // 가격제안
  @OneToMany(mappedBy = "product")
  private List<PriceOffer> priceOfferList = new ArrayList<>();

  // 채팅방
  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private List<Chatroom> chatroomList = new ArrayList<>();

  // 좋아요
  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private List<ProductLike> productLikeList = new ArrayList<>();

  // 사진
  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private List<ProductImage> productImageList = new ArrayList<>();

  public static Product create(Member member, Region region, String regionNickname, Category category,
      String title, TransactionMethod transactionMethod, String price, Boolean isEnabledOffer,
      TransactionStatus transactionStatus, String content, Boolean isPost) {

    return Product.builder()
        .member(member)
//        .region(region)
        .regionNickname(regionNickname)
        .category(category)
        .title(title)
        .transactionMethod(transactionMethod)
        .price(price)
        .isEnabledOffer(isEnabledOffer)
        .transactionStatus(transactionStatus)
        .content(content)
        .isPost(isPost)
        .build();
  }

  @Builder
  private Product(Member member, Region region, String regionNickname, Category category,
      String title,
      TransactionMethod transactionMethod, String price, Boolean isEnabledOffer,
      TransactionStatus transactionStatus, String content, Boolean isPost) {
    this.member = member;
//    this.region = region;
    this.regionNickname = regionNickname;
    this.category = category;
    this.title = title;
    this.transactionMethod = transactionMethod;
    this.price = price;
    this.isEnabledOffer = isEnabledOffer;
    this.transactionStatus = transactionStatus;
    this.content = content;
    this.isPost = isPost;
  }

}
