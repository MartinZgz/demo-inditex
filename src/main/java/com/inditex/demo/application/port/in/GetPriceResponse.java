package com.inditex.demo.application.port.in;

import java.math.BigDecimal;

public record GetPriceResponse(
        String startDate,
        String endDate,
        long productId,
        int brandId,
        BigDecimal price,
        String currency,
        int priceList

) {
    public GetPriceResponse(String startDate, String endDate, long productId, int brandId, BigDecimal price, String currency, int priceList) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
        this.brandId = brandId;
        this.price = price;
        this.currency = currency;
        this.priceList = priceList;
    }
}
