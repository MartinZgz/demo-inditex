package com.inditex.demo.adapter.in.web;

import com.inditex.demo.application.domain.exceptions.BrandNotFoundException;
import com.inditex.demo.application.domain.exceptions.PriceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
public class PriceControllerExceptionHandler {

    @ExceptionHandler(PriceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String priceNotFoundException(PriceNotFoundException ex, WebRequest request) {
        return ex.getMessage();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String constraintViolationException(ConstraintViolationException ex, WebRequest request) {
        return ex.getMessage();
    }

    @ExceptionHandler(BrandNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String brandNotFoundException(BrandNotFoundException ex, WebRequest request) {
        return ex.getMessage();
    }
}
