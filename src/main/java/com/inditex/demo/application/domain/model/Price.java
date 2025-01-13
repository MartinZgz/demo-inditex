package com.inditex.demo.application.domain.model;


import java.math.BigDecimal;

public class Price {

    private long productId;
    private Brand brandId;
    private int priceList;
    private String startDate; //The dating format that Inditex uses does not follow ISO-8601 so i will keep it as String
    private String endDate; //The dating format that Inditex uses does not follow ISO-8601 so i will keep it as String
    private BigDecimal price;
    private String currency;

    public Price() {
    }

    public Price(long productId, Brand brandId, int priceList, BigDecimal price, String startDate, String endDate, String currency) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
    }



    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
