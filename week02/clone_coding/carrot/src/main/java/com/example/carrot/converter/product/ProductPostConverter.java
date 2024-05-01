package com.example.carrot.converter.product;

import com.example.carrot.apiPayload.code.status.ErrorStatus;
import com.example.carrot.apiPayload.exception.handler.ProductHandler;
import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.model.entity.Category;
import com.example.carrot.model.entity.Member;
import com.example.carrot.model.entity.Product;
import com.example.carrot.model.enums.TransactionMethod;
import com.example.carrot.model.enums.TransactionStatus;

public class ProductPostConverter {

  public static Product toProduct(
      Member member,
//      Region region, 임시 주석
      Category category, ProductPostRequestDTO productPostRequestDTO
  ) {

    String regionNickname = productPostRequestDTO.regionNickname();
    String title = productPostRequestDTO.title();
    TransactionMethod transactionMethod = getTransactionMethod(productPostRequestDTO.transactionMethod());
    String price = productPostRequestDTO.price();
    Boolean isEnabledOffer = productPostRequestDTO.isEnabledOffer();
    String content = productPostRequestDTO.content();

    return Product.create(member, null, regionNickname, category, title, transactionMethod
        , price, isEnabledOffer, TransactionStatus.SELLING, content, true);
  }

  private static TransactionMethod getTransactionMethod(String transactionMethodName) {

    try {
      return TransactionMethod.valueOf(transactionMethodName);
    } catch (IllegalArgumentException e) {
      throw new ProductHandler(ErrorStatus._PRODUCT_BAD_REQUEST_TRANSACTION_METHOD);
    }
  }


}
