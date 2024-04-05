package org.example.domain;

import java.time.LocalDate;
import org.example.domain.common.Base;

public class Acoount extends Base {

  private int accountNo;
  private int pwd;
  private int balance;

  public int getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(int accountNo) {
    this.accountNo = accountNo;
  }

  public int getPwd() {
    return pwd;
  }

  public void setPwd(int pwd) {
    this.pwd = pwd;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}
