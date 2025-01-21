package com.inditex.demo.adapter.out.persistance;

import com.inditex.demo.application.domain.model.Price;
import com.inditex.demo.application.port.out.FetchPricesByProductPort;
import com.inditex.demo.common.InditexDateTimeFormatter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class PricePersistanceAdapter implements FetchPricesByProductPort {

    private final PriceRepository priceRepository;

    public PricePersistanceAdapter(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> fetchPricesByStartDateAndProductIdAndBrandId(String startDate, long productId, int brandId) {
        List<PriceJPAEntity> prices = priceRepository.findPricesByCriteria(InditexDateTimeFormatter.toLocalDateTime(startDate), productId, brandId);

        return prices.isEmpty() ? Collections.EMPTY_LIST : PriceMapper.INSTANCE.mapListToDomainEntityList(priceRepository.findPricesByCriteria(InditexDateTimeFormatter.toLocalDateTime(startDate), productId, brandId));
    }
}
