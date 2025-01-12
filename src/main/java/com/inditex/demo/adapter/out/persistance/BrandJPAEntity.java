package com.inditex.demo.adapter.out.persistance;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "BRAND")
public class BrandJPAEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID", nullable = false)
    private int brandId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PriceJPAEntity> prices;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PriceJPAEntity> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceJPAEntity> prices) {
        this.prices = prices;
    }
}
