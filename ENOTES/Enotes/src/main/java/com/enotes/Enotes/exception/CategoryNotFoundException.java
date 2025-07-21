package com.enotes.Enotes.exception;

import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends EnotesException{
    public CategoryNotFoundException(String message){
        super(HttpStatus.NOT_FOUND,message);
    }
}
