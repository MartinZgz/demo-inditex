package com.inditex.demo.application.domain.port.in;

import com.inditex.demo.application.port.in.GetPriceRequest;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetPriceRequestTests {

    @Test
    public void testValidRequest() {
        GetPriceRequest request = new GetPriceRequest("2023-01-10", 35455, 1);
        // Expect no exception for a valid request
    }

    @Test
    public void testInvalidStartDate() {
        assertThrows(ConstraintViolationException.class, () -> {
            new GetPriceRequest("", 35455, 1);
        }, "Expected ConstraintViolationException for an empty startDate");
    }

    @Test
    public void testInvalidProductId() {
        assertThrows(ConstraintViolationException.class, () -> {
            new GetPriceRequest("2023-01-10", 0, 1);
        }, "Expected ConstraintViolationException for a productId less than 1");
    }

    @Test
    public void testInvalidBrandId() {
        assertThrows(ConstraintViolationException.class, () -> {
            new GetPriceRequest("2023-01-10", 35455, 0);
        }, "Expected ConstraintViolationException for a brandId less than 1");
    }

    @Test
    public void testAllInvalidFields() {
        assertThrows(ConstraintViolationException.class, () -> {
            new GetPriceRequest("", 0, 0);
        }, "Expected ConstraintViolationException for all invalid fields");
    }
}
