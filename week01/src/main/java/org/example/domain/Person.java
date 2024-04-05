package org.example.domain;

import org.example.domain.common.Base;
import org.example.domain.enums.Gender;

public abstract class Person extends Base {

  private String name;
  private String socialId;

  private Gender gender;

  private String address;

  private int age;

}
