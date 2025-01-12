package com.inditex.demo.application.domain.service;

import com.inditex.demo.adapter.out.persistance.PricePersistanceAdapter;
import com.inditex.demo.application.domain.exceptions.PriceNotFoundException;
import com.inditex.demo.application.domain.model.Price;
import com.inditex.demo.application.port.in.GetPriceMapper;
import com.inditex.demo.application.port.in.GetPriceRequest;
import com.inditex.demo.application.port.in.GetPriceResponse;
import com.inditex.demo.application.port.in.GetPriceUseCase;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GetPriceService implements GetPriceUseCase {

    private final PricePersistanceAdapter pricePersistanceAdapter;

    private static final Logger logger = LoggerFactory.getLogger(GetPriceService.class);

    public GetPriceService(PricePersistanceAdapter pricePersistanceAdapter) {
        this.pricePersistanceAdapter = pricePersistanceAdapter;
    }

    @Override
    public GetPriceResponse getPrice(GetPriceRequest request) throws PriceNotFoundException {
        logger.info("Retrieving Prices for the following product Id {}", request.productId());
        List<Price> prices = pricePersistanceAdapter.fetchPricesByStartDateAndProductIdAndBrandId(request.startDate(), request.productId(), request.brandId());
        if (prices.isEmpty()) {
            throw new PriceNotFoundException("No prices found for the product, the specific date and the brand ID");
        }
        logger.info("Price found");
        return GetPriceMapper.INSTANCE.mapFromDomainEntity(prices.get(0));
    }
}
