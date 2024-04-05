package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{

  private List<Acoount> acoountList = new ArrayList<>();;

  public List<Acoount> getAcoountList() {
    return acoountList;
  }

  public void setAcoountList(List<Acoount> acoountList) {
    this.acoountList = acoountList;
  }
}
