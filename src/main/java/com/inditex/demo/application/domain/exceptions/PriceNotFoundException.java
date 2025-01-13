package com.inditex.demo.application.domain.exceptions;

public class PriceNotFoundException extends Exception {

    public PriceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
