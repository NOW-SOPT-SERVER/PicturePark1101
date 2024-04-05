package org.example.domain.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
public abstract class Base {

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public Base() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  public String getFormattedDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return this.createdAt.format(formatter);
  }
}
