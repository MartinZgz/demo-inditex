package com.inditex.demo.adapter.out.persistance;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
public class PriceId implements Serializable {

    @Column(name = "BRAND_ID", insertable=false, updatable=false)
    private int brand;

    @Column(name = "PRICE_LIST", nullable = false)
    private int priceList;

    @Column(name = "PRODUCT_ID", nullable = false)
    private int productId;
}
