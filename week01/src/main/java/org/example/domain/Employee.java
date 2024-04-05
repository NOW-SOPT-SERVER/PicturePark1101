package org.example.domain;

public class Employee extends Person{

  private long deptNo;

  private long performance; // 실적
  private long salary;

  public long getDeptNo() {
    return deptNo;
  }

  public void setDeptNo(long deptNo) {
    this.deptNo = deptNo;
  }

  public long getPerformance() {
    return performance;
  }

  public void setPerformance(long performance) {
    this.performance = performance;
  }

  public long getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }
}
