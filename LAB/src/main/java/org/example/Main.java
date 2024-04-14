package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.example.domain.Account;
import org.example.domain.Customer;
import org.example.domain.Person;
import org.example.domain.enums.Gender;
import org.example.domain.enums.ProductType;
import org.example.status.AccountException;
import org.example.status.CustomerException;
import org.example.status.TypeException;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static Account makeAccount(Customer customer) throws Exception{

    System.out.println("계좌 생성 서비스입니다.");
    System.out.println("가입 상품 유형을 선택해주세요.");
    System.out.println("1. 예금 2. 적금");

    try {
      ProductType productType = ProductType.find(Integer.parseInt(br.readLine()));

      System.out.print("계좌의 비밀번호를 설정해주세요. :");
      int pwd = Integer.parseInt(br.readLine());

      Account newAccount = Account.create(pwd, customer, productType);
      customer.setAccountList(newAccount);

      return newAccount;
    }catch (TypeException e){
      System.out.println(e.getMessage());
    }

    return null;

  }

  public static void withdraw(Customer customer) throws Exception{

    System.out.print("출금 서비스입니다. ");
    Account findAc = accountCheck(customer);
    try{
      System.out.print("출금하실 금액을 입력해주십시오.(0 이상) : ");
      int amount = Integer.parseInt(br.readLine());

      printBalance(findAc.withdraw(amount));
    }catch (CustomerException | AccountException e) {
      System.out.println(e);
    }

  }

  public static Account accountCheck(Customer customer) throws Exception{

    Account findAc = null;
    System.out.print("계좌번호를 입력해주세요 :");

    try {
      findAc = customer.findAccount(Integer.parseInt(br.readLine()));

      System.out.print("계좌의 비밀번호를 입력해주세요 : ");
      findAc.checkPwd(Integer.parseInt(br.readLine()));

      return findAc;
    }catch ( AccountException e){
      System.out.println(e);
    }

    return findAc;
  }

  public static void printBalance(long balance) {
    System.out.println("잔액 : " +balance);
  }

  public static void saving(Customer customer) throws Exception{

    System.out.print("입금 서비스입니다. ");

    try{
      Account findAc = accountCheck(customer);

      System.out.print("입금 금액을 입력해주십시오.(0 이상) : ");
      int amount = Integer.parseInt(br.readLine());

      printBalance(findAc.saving(amount));
    }catch (CustomerException | AccountException e) {
      System.out.println(e);
    }
  }

  public static void transfer(Customer c1, Customer c2) throws Exception{

    System.out.print("이체 서비스입니다. ");
    Account findC1Ac = accountCheck(c1);

    try{
      System.out.print("이체받을 상대방의 계좌번호를 입력해주세요.");
      Account findC2Ac = c2.findAccount(Integer.parseInt(br.readLine()));

      System.out.print("이체하실 금액을 입력해주십시오.(0 이상)");
      int amount = Integer.parseInt(br.readLine());
      findC1Ac.transfer(findC2Ac, amount);
    }catch (CustomerException | AccountException e) {
      System.out.println(e);
    }
  }

  public static int printService() throws Exception {
    System.out.println("---------------");
    System.out.println("은행 서비스입니다. 원하시는 서비스 번호를 입력해주세요. 종료를 원하시면 -1을 입력해주세요.");
    System.out.println("1. 계좌생성 2. 출금 3. 입금 4. 계좌확인 5. 고객정보 확인 6. 계좌이체");
    System.out.println("---------------");
    return Integer.parseInt(br.readLine());
  }

  public static void main(String[] args) throws Exception {


    // 더미데이터 생성
    Person p1 = Person.of("c1", "111111-111111", Gender.MALE, "seoul", 26);
    Person p2 = Person.of("c2", "222222-222222", Gender.FEMALE, "guri", 25);
    Customer c1 = new Customer(p1);
    Customer c2 = new Customer(p2);
    Account tempAccount = Account.create(0000, c2, ProductType.find(1));
    c2.setAccountList(tempAccount);

    // c1이 서비스를 이용한다고 가정
    int input = printService();
    while (input != -1) {
      switch (input) {
        case 1 : // 계좌생성
          makeAccount(c1);
          break;
        case 2: // 출금
          withdraw(c1);
          break;
        case 3: // 입금
          saving(c1);
          break;
        case 4: // 계좌확인
          c1.printAllAccount();
          break;
        case 5:  // 고객정보 확인
          c1.printCustomerInfo();
          break;
        case 6 : // 계좌이체
          transfer(c1, c2);
          break;

      }
      input = printService();
    }

    br.close();
  }
}
