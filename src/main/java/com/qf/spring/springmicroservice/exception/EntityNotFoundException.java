package com.qf.spring.springmicroservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException() {
    }
}
