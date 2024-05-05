package com.example.carrot.apiPayload.dto;

public record ErrorResponse(
    boolean isSuccess,

    int code,
    String message
) {
  public static ErrorResponse of(int status, String message) {
    return new ErrorResponse(false, status, message);
  }
  public static ErrorResponse of(ErrorMessage errorMessage) {
    return new ErrorResponse(false, errorMessage.getStatus(), errorMessage.getMessage());
  }
}
