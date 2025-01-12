package com.inditex.demo.application.domain.model;

public enum Brand {
    ZARA(1);

    private final int brandId;

    Brand(int brandId) {
        this.brandId = brandId;
    }

    public int getBrandId() {
        return brandId;
    }

    public static Brand fromBrandId(int brandId) {
        for (Brand brand : Brand.values()) {
            if (brand.getBrandId() == brandId) {
                return brand;
            }
        }
        throw new IllegalArgumentException("No Brand found with brandId " + brandId);
    }
}
