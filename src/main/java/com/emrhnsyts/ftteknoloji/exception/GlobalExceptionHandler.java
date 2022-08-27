package com.emrhnsyts.ftteknoloji.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(KullaniciNotFoundException.class)
    public ResponseEntity<Object> handleKullaniciNotFoundException(Exception exception) {
        return exceptionUtil(exception.getMessage());
    }

    @ExceptionHandler(UrunNotFoundException.class)
    public ResponseEntity<Object> handleUrunNotFoundException(Exception exception) {
        return exceptionUtil(exception.getMessage());
    }

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<Object> handleDateTimeException(Exception exception) {
        return exceptionUtil(exception.getMessage());
    }


    private ResponseEntity<Object> exceptionUtil(String message) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(message)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .createdAt(new Date())
                .build();

        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }
}
