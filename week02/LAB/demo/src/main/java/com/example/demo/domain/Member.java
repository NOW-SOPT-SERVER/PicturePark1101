package com.example.demo.domain;

import com.example.seminar.domain.enums.Part;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.ORDINAL)
  private Part part;

  private int age;

  public static Member create(String name, Part part, int age) {
    return Member.builder()
        .name(name)
        .part(part)
        .age(age)
        .build();
  }

  @Builder
  private Member(String name, Part part, int age) {
    this.name = name;
    this.part = part;
    this.age = age;
  }
}
