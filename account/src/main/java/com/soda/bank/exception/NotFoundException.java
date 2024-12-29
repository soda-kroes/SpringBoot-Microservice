package com.soda.bank.exception;

import lombok.Data;

@Data
public class NotFoundException extends Exception{
    private Long id;
    public NotFoundException(String message) {
        super(message);
        this.id = id;
    }
}
