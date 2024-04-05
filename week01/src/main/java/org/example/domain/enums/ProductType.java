package org.example.domain.enums;

import java.util.Arrays;
import org.example.status.TypeException;

public enum ProductType {
  SAVINGS_ACCOUNT(1), // 예금
  INSTALLMENT_SAVINGS_ACCOUNT(2); // 적금

  private final int id;

  ProductType(int id) {
    this.id = id;
  }

  // 숫자 리턴
  public int getValue() {
    return id;
  }

  public static ProductType find(int inputValue) throws Exception {
    return Arrays.stream(ProductType.values())
        .filter(it -> it.id == inputValue)
        .findAny()
        .orElseThrow(() -> new TypeException("존재하지 않는 상품입니다."));
  }
}
