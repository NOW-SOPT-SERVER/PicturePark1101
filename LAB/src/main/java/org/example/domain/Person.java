package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.common.Base;
import org.example.domain.enums.Gender;

@Getter
@Setter
public class Person extends Base {

  private Base base;
  private String name;
  private String socialId;
  private Gender gender;
  private String address;
  private int age;

  private Person(String name, String socialId, Gender gender, String address, int age) {
    super();
    this.name = name;
    this.socialId = socialId;
    this.gender = gender;
    this.address = address;
    this.age = age;
  }

  public static Person of(String name, String socialId, Gender gender, String address, int age) {
    return new Person(name, socialId, gender, address, age);
  }

}
