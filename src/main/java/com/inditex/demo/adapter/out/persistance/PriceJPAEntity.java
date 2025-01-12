package com.inditex.demo.adapter.out.persistance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
@ToString
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
}
