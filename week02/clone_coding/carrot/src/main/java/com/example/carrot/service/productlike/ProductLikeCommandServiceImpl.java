package com.example.carrot.service.productlike;


import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.entity.Member;
import com.example.carrot.model.entity.Product;
import com.example.carrot.model.entity.ProductLike;
import com.example.carrot.repository.ProductLikeRepository;
import com.example.carrot.repository.ProductRepository;
import com.example.carrot.service.member.MemberService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductLikeCommandServiceImpl implements ProductLikeCommandService {

  private final ProductLikeRepository productLikeRepository;
  private final MemberService memberService;
//  private final ProductQueryService productQueryService;
  private final ProductRepository productRepository;

  public ProductLike findById(Long id) {

    return productLikeRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.PRODUCTLIKE_NOT_FOUND_BY_ID_EXCEPTION));
  }

  public Optional<ProductLike> findByMemberIdAndProductId(Long memberId, Long productId) {
    return productLikeRepository.findByMemberIdAndProductId(memberId, productId);
  }


  public Long countByProductId(Long productId) {
    return productLikeRepository.countByProductId(productId);
  }

  @Transactional
  public Boolean actionLike(Long memberId, Long productId) {
    // 좋아요 테이블에서 찾기
    Optional<ProductLike> findProductLike = findByMemberIdAndProductId(memberId, productId);

    if (findProductLike.isEmpty()) {
      // 없으면 ProductLike DB에 추가
      // 멤버 먼저 거르기
      Member member = memberService.findById(memberId);
//      Product product = productQueryService.findById(productId); 순환참조 문제 발생

      Product product = productRepository.findById(productId)
          .orElseThrow(
              () -> new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND_BY_ID_EXCEPTION));

      ProductLike newProductLike = ProductLike.create(member, product);
      productLikeRepository.save(newProductLike);
      return true;
    } else {
      // 있으면 DB에서 제거
      productLikeRepository.delete(findProductLike.get());
      return false;
    }
  }
}
