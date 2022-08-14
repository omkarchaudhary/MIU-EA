package com.miu.firstspringdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentNotFound extends RuntimeException{
    public StudentNotFound(String message) {
        super(message);
    }
}
