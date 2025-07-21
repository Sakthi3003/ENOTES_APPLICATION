package com.enotes.Enotes.exception;

import org.springframework.http.HttpStatus;

public class EnotesException extends RuntimeException {
    private HttpStatus status;
    public EnotesException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getHttpStatus(){
        return status;
    }
}
