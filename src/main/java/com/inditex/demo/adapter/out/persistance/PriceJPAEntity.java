package com.inditex.demo.adapter.out.persistance;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "PRICES")
public class PriceJPAEntity implements Serializable {

    @EmbeddedId
    private PriceId id;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private BrandJPAEntity brand;

    @Column(name = "START_DATE", nullable = false)
    private String startDate;

    @Column(name = "END_DATE", nullable = false)
    private String endDate;

    @Column(name = "PRIORITY", nullable = false)
    private int priority;

    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "CURR", nullable = false, length = 3)
    private String currency;

    public PriceId getId() {
        return id;
    }

    public void setId(PriceId id) {
        this.id = id;
    }

    public BrandJPAEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandJPAEntity brand) {
        this.brand = brand;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
