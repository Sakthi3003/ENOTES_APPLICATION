package com.enotes.Enotes.exception;

import org.springframework.http.HttpStatus;

public class ExistDataException extends EnotesException{
    public ExistDataException(String message) {
        super(HttpStatus.CONFLICT, message); // 409 client error
    }
}
