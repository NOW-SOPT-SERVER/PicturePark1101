package com.example.carrot.converter.product;

import com.example.carrot.apiPayload.dto.ErrorMessage;
import com.example.carrot.exception.NotFoundException;
import com.example.carrot.model.dto.request.product.ProductPostRequestDTO;
import com.example.carrot.model.entity.Category;
import com.example.carrot.model.entity.Member;
import com.example.carrot.model.entity.Product;
import com.example.carrot.model.entity.Region;
import com.example.carrot.model.enums.TransactionMethod;
import com.example.carrot.model.enums.TransactionStatus;

public class ProductPostConverter {

  public static Product toProduct(
      Member member,
      Region region,
      Category category, ProductPostRequestDTO productPostRequestDTO
  ) {

    String regionNickname = productPostRequestDTO.regionNickname();
    String title = productPostRequestDTO.title();
    TransactionMethod transactionMethod = getTransactionMethod(productPostRequestDTO.transactionMethod());
    String price = productPostRequestDTO.price();
    Boolean isEnabledOffer = productPostRequestDTO.isEnabledOffer();
    String content = productPostRequestDTO.content();

    return Product.create(member, region, regionNickname, category, title, transactionMethod
        , price, isEnabledOffer, TransactionStatus.SELLING, content, true);
  }

  private static TransactionMethod getTransactionMethod(String transactionMethodName) {

    try {
      return TransactionMethod.valueOf(transactionMethodName);
    } catch (IllegalArgumentException e) {
      throw new NotFoundException(ErrorMessage.TRANSACTION_METHOD_NOT_VALIDATED);
    }
  }


}
