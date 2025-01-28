package com.pruebabcnc;

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

import com.pruebabcnc.application.useCases.GetPriceByProductIdBrandIdAndDateUseCase;
import com.pruebabcnc.domain.model.Price;
import com.pruebabcnc.domain.repository.PricesRepository;
import com.pruebabcnc.exceptions.DateParserException;
import com.pruebabcnc.utils.CommonUtilities;

@SpringBootTest
public class PruebaBcncApplicationTests {
	@Mock
    private PricesRepository pricesRepository;
    
    @InjectMocks
    private GetPriceByProductIdBrandIdAndDateUseCase getPriceByProductIdBrandIdAndDateUseCase;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonUtilities.YYYY_MM_DD_HH_MM_SS_HYPHEN_SEPARATOR);
    
    Price priceEsperado;
    @BeforeEach
    void setUp() {
    	priceEsperado = new Price();
    	priceEsperado.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
    	priceEsperado.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
    	priceEsperado.setPriceList(1);
    	priceEsperado.setBrandId(1);
    	priceEsperado.setProductId(35455);
    	priceEsperado.setPriority(0);
    	priceEsperado.setPrice(35.50);
    	priceEsperado.setCurrency("EUR");
    }

    @Test
    void testGetPriceByProductIdBrandIdAndDateCorrectDateFormat() throws DateParserException {
        Mockito.when(pricesRepository.findPriceByProductIdBrandIdAndDate(35455, 1, LocalDateTime.parse("2020-07-10 00:00:00",formatter))).thenReturn(priceEsperado);

    	Price price = getPriceByProductIdBrandIdAndDateUseCase.getPriceByProductIdBrandIdAndDate(35455, 1, "2020-07-10 00:00:00");
        assertNotNull(price);
    	assertEquals(price.getProductId(), priceEsperado.getProductId());
    }

    @Test
    void testGetPriceByProductIdBrandIdAndDateIncorrectDateFormat() throws DateParserException {
        assertThrows(DateParserException.class,() -> getPriceByProductIdBrandIdAndDateUseCase.getPriceByProductIdBrandIdAndDate(35456, 1, "15-08-2020 00:00:00"));
    }

}
