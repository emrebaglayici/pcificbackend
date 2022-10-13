package com.pcific.pcificbackend.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MustBeGraterThanZero extends RuntimeException{
    public MustBeGraterThanZero(String message) {
        super(message);
    }
}
