package com.inditex.demo.application.port.in;

import com.inditex.demo.application.domain.exceptions.BrandNotFoundException;
import com.inditex.demo.application.domain.exceptions.PriceNotFoundException;

public interface GetPriceUseCase {

    GetPriceResponse getPrice(GetPriceRequest request) throws PriceNotFoundException, BrandNotFoundException;
}
