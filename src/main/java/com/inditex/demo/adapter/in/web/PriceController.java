package com.inditex.demo.adapter.in.web;

import com.inditex.demo.application.domain.exceptions.PriceNotFoundException;
import com.inditex.demo.application.port.in.GetPriceRequest;
import com.inditex.demo.application.port.in.GetPriceResponse;
import com.inditex.demo.application.port.in.GetPriceUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PriceController {

    private static final Logger log = LoggerFactory.getLogger(PriceController.class);

    private final GetPriceUseCase getPriceUseCase;

    public PriceController(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }

    @RequestMapping(value = "/prices",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<GetPriceResponse> getPrice(
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "productId") int productId,
            @RequestParam(value = "brandId") int brandId
) throws PriceNotFoundException {
        return new ResponseEntity<>(getPriceUseCase.getPrice(new GetPriceRequest(startDate, productId, brandId)), HttpStatus.OK);
    }

}
