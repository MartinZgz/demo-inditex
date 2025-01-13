package com.inditex.demo.application.domain.exceptions;

public class BrandNotFoundException extends Exception {

    public BrandNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
