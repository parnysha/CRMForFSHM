package org.example.crmforfshm.controller;

import org.example.crmforfshm.dto.JSONErr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<JSONErr> handleException(IllegalArgumentException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new JSONErr(exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONErr> handleException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new JSONErr("Произошла неожиданная ошибка"));
    }
}
