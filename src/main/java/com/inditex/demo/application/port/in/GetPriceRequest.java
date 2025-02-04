package com.inditex.demo.application.port.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static com.inditex.demo.common.validation.Validation.validate;

public record GetPriceRequest(
        @NotNull @NotBlank String startDate,
        @Min(1) long productId,
        @Min(1) int brandId
) {
    public GetPriceRequest(
            String startDate,
            long productId,
            int brandId) {
        this.startDate = startDate;
        this.productId = productId;
        this.brandId = brandId;
        validate(this);
    }
}
