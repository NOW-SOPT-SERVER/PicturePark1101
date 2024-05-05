package com.example.carrot.apiPayload.dto;


public record SuccessStatusResponse<T>(
    int status,
    String message,
    T result
) {

  public static SuccessStatusResponse of(SuccessMessage successMessage) {
    return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage(), null);
  }

  public static <T> SuccessStatusResponse of(SuccessMessage successMessage, T responseDto) {
    return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage(), responseDto);
  }

}