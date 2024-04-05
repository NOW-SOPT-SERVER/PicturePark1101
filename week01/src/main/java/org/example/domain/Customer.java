package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.example.status.CustomerException;

@Getter
@Setter
public class Customer {

  private final Person person;
  private List<Account> accountList;

  public Customer(Person person) {
    this.person = person;
    accountList = new ArrayList<>();
  }

  public void setAccountList(Account account) {
    if (this.accountList == null) {
      accountList = new ArrayList<>();
    }
    this.accountList.add(account);
  }

  public Account findAccount(int acNum) throws Exception{

    for (Account ac : this.accountList) {
      if (ac.getAccountNo() == acNum) {
        return ac;
      }
    }

    throw new CustomerException("고객님께 해당 계좌가 존재하지 않습니다.");
  }

  public void printAllAccount() {
    for (Account ac : this.accountList) {
      ac.printAccount();

    }
  }

  public void printCustomerInfo() {

    System.out.println("고객명 : " +this.person.getName());
    System.out.println("성별 : " +this.person.getGender());
    System.out.println("주소 : " +this.person.getAddress());
    System.out.println("가입일 : " +this.person.getFormattedDate());
    System.out.println("소유 계좌 갯수 : " +this.accountList.size());
  }

}
