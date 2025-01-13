package com.inditex.demo.application.domain.model;

import com.inditex.demo.application.domain.exceptions.BrandNotFoundException;

public enum Brand {
    ZARA(1);

    private final int brandId;

    Brand(int brandId) {
        this.brandId = brandId;
    }

    public int getBrandId() {
        return brandId;
    }

    public static Brand fromBrandId(int brandId) throws BrandNotFoundException {
        for (Brand brand : Brand.values()) {
            if (brand.getBrandId() == brandId) {
                return brand;
            }
        }
        throw new BrandNotFoundException("No Brand found with brandId " + brandId);
    }
}
