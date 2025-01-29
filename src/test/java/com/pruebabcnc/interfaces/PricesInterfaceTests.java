package com.pruebabcnc.interfaces;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PricesInterfaceTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPricesController14Day10Hour() throws Exception {
        mockMvc.perform(get("/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("date", "2020-06-14 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.priceValue").value(35.50));
    }
    
    @Test
    public void testPricesController14Day16Hour() throws Exception {
        mockMvc.perform(get("/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("date", "2020-06-14 16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.priceValue").value(25.45));
    }
    
    @Test
    public void testPricesController14Day21Hour() throws Exception {
        mockMvc.perform(get("/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("date", "2020-06-14 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.priceValue").value(35.50));
    }
    
    @Test
    public void testPricesController15Day10Hour() throws Exception {
        mockMvc.perform(get("/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("date", "2020-06-15 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.priceValue").value(30.50));
    }
    
    @Test
    public void testPricesController16Day21Hour() throws Exception {
        mockMvc.perform(get("/prices")
                .param("productId", "35455")
                .param("brandId", "1")
                .param("date", "2020-06-16 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.priceValue").value(38.95));
    }
    
    @Test
    public void testPricesControllerBadPath() throws Exception {
        mockMvc.perform(get("/prices")
                .param("productId", "35455")
                .param("date", "2020-06-16 21:00:00"))
                .andExpect(status().is4xxClientError());
    }
}
