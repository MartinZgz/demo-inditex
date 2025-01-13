package com.inditex.demo.adapter.out.persistance;

import com.inditex.demo.application.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Import({PricePersistanceAdapter.class, PriceMapperImpl.class})
public class PricePersistanceAdapterTest {

    @Autowired
    PricePersistanceAdapter pricePersistanceAdapter;

    @Test
    public void testFindPricesByCriteria() {
        String startDate = "2020-06-14-16.00.00";
        long productId = 35455;
        int brandId = 1;

        List<Price> prices = pricePersistanceAdapter.fetchPricesByStartDateAndProductIdAndBrandId(startDate, productId, brandId);

        assertEquals(2, prices.size());
    }

    @Test
    public void testFindPricesByCriteriaWithNoMatch() {
        String startDate = "2020-06-14-16.00.00";
        long productId = 99999;
        int brandId = 1;

        List<Price> prices = pricePersistanceAdapter.fetchPricesByStartDateAndProductIdAndBrandId(startDate, productId, brandId);

        assertTrue(prices.isEmpty(), "price list should be empty for a query with an unknown product Id");
    }
}
