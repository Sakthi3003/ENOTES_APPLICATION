package com.enotes.Enotes.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResponse {
    private HttpStatus status;
    private Integer statusCode;
    private String message;
    private LocalDateTime timestamp;
}
