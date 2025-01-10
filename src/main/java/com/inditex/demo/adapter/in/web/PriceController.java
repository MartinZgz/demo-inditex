package com.inditex.demo.adapter.in.web;

import com.inditex.demo.application.port.in.GetPriceRequest;
import com.inditex.demo.application.port.in.GetPriceResponse;
import com.inditex.demo.application.port.in.GetPriceUseCase;
import com.inditex.demo.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class PriceController {

    private static final Logger log = LoggerFactory.getLogger(PriceController.class);

    private final GetPriceUseCase getPricesUseCase;

    @RequestMapping(value = "/prices",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<GetPriceResponse> getPrice(
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "productId") int productId,
            @RequestParam(value = "brandId") int brandId
)   {
        return new ResponseEntity<>(getPricesUseCase.getPrice(new GetPriceRequest(startDate, productId, brandId)), HttpStatus.OK);
    }

}
