package com.inditex.demo.application.port.out;

import com.inditex.demo.application.domain.model.Price;

import java.util.List;

public interface FetchPricesByProductPort {

    List<Price> fetchPricesByStartDateAndProductIdAndBrandId (String startDate, long productId, int brandId);
}
