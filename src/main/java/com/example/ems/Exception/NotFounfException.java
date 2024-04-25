package com.example.ems.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFounfException extends RuntimeException{
    public  NotFounfException(String message){
        super(message);
    }
}
