package com.example.User.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException{

    String message;
    public CustomException (String message){
        super(message);
        this.message=message;
    }

    public void userException() throws Exception {

        throw new CustomException(message);
    }
}
