package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Customer extends Person{

  private List<Account> accountList = new ArrayList<>();;

}
