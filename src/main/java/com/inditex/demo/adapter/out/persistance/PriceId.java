package com.inditex.demo.adapter.out.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PriceId implements Serializable {

    @Column(name = "BRAND_ID", insertable=false, updatable=false)
    private int brandId;

    @Column(name = "PRICE_LIST", nullable = false)
    private int priceList;

    @Column(name = "PRODUCT_ID", nullable = false)
    private int productId;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
