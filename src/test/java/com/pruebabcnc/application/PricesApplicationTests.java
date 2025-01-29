package com.pruebabcnc.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pruebabcnc.application.usecases.GetPriceByProductIdBrandIdAndDateUseCase;
import com.pruebabcnc.domain.model.Price;
import com.pruebabcnc.domain.repository.PricesRepository;
import com.pruebabcnc.exceptions.DateParserException;
import com.pruebabcnc.exceptions.NotFoundException;
import com.pruebabcnc.utils.CommonUtilities;

@SpringBootTest
class PricesApplicationTests {
	@Mock
    private PricesRepository pricesRepository;
    
    @InjectMocks
    private GetPriceByProductIdBrandIdAndDateUseCase getPriceByProductIdBrandIdAndDateUseCase;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonUtilities.YYYY_MM_DD_HH_MM_SS_HYPHEN_SEPARATOR);
    
    Price priceExpected;
    @BeforeEach
    void setUp() {
    	priceExpected = new Price();
    	priceExpected.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
    	priceExpected.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
    	priceExpected.setRateNumber(1);
    	priceExpected.setBrand(1);
    	priceExpected.setProduct(35455);
    	priceExpected.setPriceValue(35.50);
    	priceExpected.setCurrency("EUR");
    }

    @Test
    void testGetPriceByProductIdBrandIdAndDateCorrectDateFormat() throws DateParserException, NotFoundException {
        Mockito.when(pricesRepository.findPriceByProductIdBrandIdAndDate(35455, 1, LocalDateTime.parse("2020-07-10 00:00:00",formatter))).thenReturn(priceExpected);

    	Price price = getPriceByProductIdBrandIdAndDateUseCase.getPriceByProductIdBrandIdAndDate(35455, 1, "2020-07-10 00:00:00");
        assertNotNull(price);
    	assertEquals(priceExpected.getProduct(),price.getProduct());
    }

    @Test
    void testGetPriceByProductIdBrandIdAndDateIncorrectDateFormat() throws DateParserException {
        assertThrows(DateParserException.class,() -> getPriceByProductIdBrandIdAndDateUseCase.getPriceByProductIdBrandIdAndDate(35455, 1, "15-08-2020 00:00:00"));
    }
    
    @Test
    void testGetPriceByProductIdBrandIdAndDateNotFound() throws NotFoundException {
        assertThrows(NotFoundException.class,() -> getPriceByProductIdBrandIdAndDateUseCase.getPriceByProductIdBrandIdAndDate(35456, 1, "2020-08-15 00:00:00"));
    }
    
}
