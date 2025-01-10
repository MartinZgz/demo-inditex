package com.inditex.demo.adapter.in.web;

import com.inditex.demo.application.port.in.GetPriceRequest;
import com.inditex.demo.application.port.in.GetPriceUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PriceController.class)
public class PriceControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GetPriceUseCase getPriceUseCase;

    private static final String START_DATE = "2020-06-14-10:00:00";
    private static final String PRODUCT_ID = "35455";
    private static final String BRAND_ID = "1";

    @Test
    public void shouldFetchPriceWhenPriceExists() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("startDate", START_DATE)
                        .param("productId", PRODUCT_ID)
                        .param("brandId", BRAND_ID)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        then(getPriceUseCase).should()
                .getPrice(eq(new GetPriceRequest(
                        START_DATE,
                        Integer.parseInt(PRODUCT_ID),
                        Integer.parseInt(BRAND_ID))));
    }
}
