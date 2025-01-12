package com.inditex.demo.adapter.out.persistance;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "BRAND")
@Getter
@Setter
public class BrandJPAEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID", nullable = false)
    private int brandId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PriceJPAEntity> prices;
}
