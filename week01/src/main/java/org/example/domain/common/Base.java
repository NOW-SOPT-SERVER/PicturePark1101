package org.example.domain.common;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public abstract class Base {

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

}
