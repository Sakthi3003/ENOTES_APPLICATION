package com.enotes.Enotes.exception;

import com.enotes.Enotes.dto.ExceptionResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EnotesException.class)
    public ResponseEntity<?> handleCategoryNotFoundException(EnotesException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(exception.getMessage());
        exceptionResponse.setStatus(exception.getHttpStatus());
        exceptionResponse.setStatusCode(exception.getHttpStatus().value());
        exceptionResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, exception.getHttpStatus());
    }

    // Handle any other unexpected exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGlobalException(Exception ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(LocalDateTime.now());

        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        });

        response.setMessage("Validation failed for one or more fields.");
        response.setErrors(fieldErrors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleConstraintViolationException(ConstraintViolationException ex){
        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setTimestamp(LocalDateTime.now());
        response.setMessage(ex.getConstraintViolations().iterator().next().getMessage());
        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
