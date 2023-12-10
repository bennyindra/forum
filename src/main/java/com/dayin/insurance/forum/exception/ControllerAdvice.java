package com.dayin.insurance.forum.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Order(-2147483648)
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<Object> handleApplicationException(BusinessException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message", e.getMessage()));
    }
}
