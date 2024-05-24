package com.example.demo.common;

import com.example.demo.common.dto.ErrorResponse;
import com.example.demo.exception.CustomValidateException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.UnauthorizedException;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
        ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage()));
  }
  @ExceptionHandler(NotFoundException.class)
  protected ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getErrorMessage()));
  }

  @ExceptionHandler(CustomValidateException.class)
  protected ResponseEntity<ErrorResponse> handleNotFoundException(CustomValidateException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getErrorMessage()));
  }

  @ExceptionHandler(UnauthorizedException.class)
  protected ResponseEntity<ErrorResponse> handlerUnauthorizedException(UnauthorizedException e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(ErrorResponse.of(e.getErrorMessage().getStatus(), e.getErrorMessage().getMessage()));
  }
}
