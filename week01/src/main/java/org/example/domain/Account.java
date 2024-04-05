package org.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.common.Base;

@Builder
@Getter
@Setter
public class Account extends Base {

  private int accountNo;
  private int pwd;
  private int balance;

}
