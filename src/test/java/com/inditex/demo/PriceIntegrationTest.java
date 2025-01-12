package com.inditex.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenProduct35455AndBrand1_whenRequestingPriceAt10amOnJune14_thenPriceShouldBe35_50() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("startDate", "2020-06-14-10.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void givenProduct35455AndBrand1_whenRequestingPriceAt4pmOnJune14_thenPriceShouldBe25_45() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("startDate", "2020-06-14-16.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    public void givenProduct35455AndBrand1_whenRequestingPriceAt9pmOnJune14_thenPriceShouldBe35_50() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("startDate", "2020-06-14-21.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void givenProduct35455AndBrand1_whenRequestingPriceAt10amOnJune15_thenPriceShouldBe30_50() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("startDate", "2020-06-15-10.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    public void givenProduct35455AndBrand1_whenRequestingPriceAt9pmOnJune16_thenPriceShouldBe38_95() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("startDate", "2020-06-16-21.00.00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95));
    }
}

