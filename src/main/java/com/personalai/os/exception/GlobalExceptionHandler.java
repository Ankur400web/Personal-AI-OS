package com.personalai.os.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEmail(EmailAlreadyExistException exception){

        ErrorResponse response = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                exception.getMessage(),
                OffsetDateTime.now(),
                null
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }
}
