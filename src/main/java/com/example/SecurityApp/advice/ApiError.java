package com.example.SecurityApp.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private LocalDateTime localDateTime;
    private HttpStatus status;
    private String error;

    public ApiError() {
        this.localDateTime = LocalDateTime.now();
    }

    public ApiError(HttpStatus status, String error) {
        this();
        this.status = status;
        this.error = error;
    }
}
