package org.example.domain;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.common.Base;
import org.example.domain.enums.ProductType;
import org.example.status.AccountException;

@Getter
@Setter
public class Account extends Base {

  private int accountNo;
  private int pwd;
  private long balance;
  private Customer customer;
  private ProductType productType;

  private Account(int pwd, Customer customer,
      ProductType productType) {
    super();
    Random random = new Random();
    this.accountNo = random.nextInt(90000) + 10000; // 5자리 난수
    this.pwd = pwd;
    this.balance = 0;
    this.customer = customer;
    this.productType = productType;
  }

  public static Account create(int pwd, Customer customer,
      ProductType productType) {
    return new Account(pwd, customer, productType);
  }

  // 출금
  public long withdraw(long amount) throws Exception {

    if (this.balance - amount >= 0) {
      this.balance -= amount;
    } else {
      throw new AccountException("계좌의 잔액이 부족합니다.");
    }

    return this.balance;
  }

  // 입금
  public long saving(long amount) {
    this.balance += amount;
    return this.balance;
  }

  // 비번체크
  public void checkPwd(int input) throws Exception {
    if (this.pwd != input){
      throw new AccountException("비밀번호가 일치하지 않습니다.");
    }
  }

  // 계좌이체
  public void transfer(Account recipient, int amount) throws Exception{

    if (this.balance - amount >= 0) {
      this.withdraw(amount);
      recipient.saving(amount);
    } else {
      throw new AccountException("계좌의 잔액이 부족합니다.");
    }
  }

  public void printAccount(){

    System.out.println("소유자명 : " +this.customer.getPerson().getName());
    System.out.println("계좌번호 : " +this.accountNo);
    System.out.println("비밀번호 : " +this.pwd);
    System.out.println("계좌금액 : " +this.balance);
    System.out.println("상품유형 : " +this.productType);
    System.out.println("가입일 : " +this.getFormattedDate());

  }


}
