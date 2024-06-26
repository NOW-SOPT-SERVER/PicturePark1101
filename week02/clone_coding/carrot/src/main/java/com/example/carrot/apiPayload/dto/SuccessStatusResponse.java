package com.example.carrot.apiPayload.dto;


public record SuccessStatusResponse<T>(

    boolean isSuccess,

    int code,
    String message,
    T result
) {

  public static SuccessStatusResponse of(SuccessMessage successMessage) {
    return new SuccessStatusResponse(true, successMessage.getStatus(), successMessage.getMessage(), null);
  }

  public static <T> SuccessStatusResponse<T> of(SuccessMessage successMessage, T responseDto) {
    return new SuccessStatusResponse(true, successMessage.getStatus(), successMessage.getMessage(), responseDto);
  }

}