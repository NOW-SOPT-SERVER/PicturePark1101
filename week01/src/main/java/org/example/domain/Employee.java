package org.example.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Employee extends Person{

  private long deptNo;

  private long performance; // 실적
  private long salary;

}
