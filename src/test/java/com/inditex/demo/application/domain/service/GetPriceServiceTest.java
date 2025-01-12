package com.inditex.demo.application.domain.service;

import com.inditex.demo.adapter.out.persistance.PricePersistanceAdapter;
import com.inditex.demo.application.domain.exceptions.PriceNotFoundException;
import com.inditex.demo.application.domain.model.Brand;
import com.inditex.demo.application.domain.model.Price;
import com.inditex.demo.application.port.in.GetPriceRequest;
import com.inditex.demo.application.port.in.GetPriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class GetPriceServiceTest {

    @Mock
    private PricePersistanceAdapter pricePersistanceAdapter;

    @InjectMocks
    private GetPriceService getPriceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenValidRequest_whenPricesExist_thenReturnsGetPriceResponse() throws PriceNotFoundException {
        GetPriceRequest request = new GetPriceRequest("2020-06-14-10.00.00", 35455, 1);

        Price price = new Price(
                35455,
                Brand.ZARA,
                1,
                new BigDecimal("35.50"),
                "2020-06-14-00.00.00",
                "2020-12-31-23.59.59",
                "EUR"
        );

        when(pricePersistanceAdapter.fetchPricesByStartDateAndProductIdAndBrandId(
                request.startDate(), request.productId(), request.brandId()
        )).thenReturn(List.of(price));

        GetPriceResponse response = getPriceService.getPrice(request);

        assertNotNull(response);
        assertEquals(35455, response.productId());
        assertEquals(1, response.brandId());
        assertEquals("2020-06-14-00.00.00", response.startDate());
        assertEquals("2020-12-31-23.59.59", response.endDate());
        assertEquals(new BigDecimal("35.50"), response.price());
        assertEquals("EUR", response.currency());
        assertEquals(1, response.priceList());
    }

    @Test
    public void givenValidRequest_whenPricesDoesNotExist_thenReturnsPriceNotFoundException() {
        GetPriceRequest request = new GetPriceRequest("2020-06-14-10.00.00", 35455, 1);

        when(pricePersistanceAdapter.fetchPricesByStartDateAndProductIdAndBrandId(
                request.startDate(), request.productId(), request.brandId()
        )).thenReturn(Collections.EMPTY_LIST);

        assertThrows(PriceNotFoundException.class, () -> getPriceService.getPrice(request));
    }
}
