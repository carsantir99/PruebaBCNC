package com.pruebabcnc.infraestructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pruebabcnc.domain.model.Price;
import com.pruebabcnc.infraestructure.entities.PriceEntity;
import com.pruebabcnc.infraestructure.repositories.PricesRepositoryImpl;
import com.pruebabcnc.infraestructure.repositories.interfaces.JpaPricesRepository;
import com.pruebabcnc.utils.CommonUtilities;

@SpringBootTest
class PricesInfraestructureTests {
	
	@Mock
    private JpaPricesRepository jpaPricesRepository;
    
    @InjectMocks
    private PricesRepositoryImpl pricesRepositoryImpl;
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CommonUtilities.YYYY_MM_DD_HH_MM_SS_HYPHEN_SEPARATOR);

    private List<PriceEntity> priceEntities;

    @BeforeEach
    void setUp() {
    	priceEntities = new ArrayList<PriceEntity>(1);
    	PriceEntity priceEntity = new PriceEntity();
    	priceEntity.setBrandId(1);
    	priceEntity.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
    	priceEntity.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
    	priceEntity.setPriceList(1);
    	priceEntity.setProductId(35455);
    	priceEntity.setPriority(0);
    	priceEntity.setPrice(35.50);
    	priceEntity.setCurrency("EUR");
    	
    	priceEntities.add(priceEntity);
    }

    @Test
    void testFindPriceByProductIdBrandIdAndDate() {
        Mockito.when(jpaPricesRepository.findPriceByProductIdBrandIdAndDate(35455, 1, LocalDateTime.parse("2020-08-15 00:00:00", formatter)))
        .thenReturn(priceEntities);

    	Price price = pricesRepositoryImpl.findPriceByProductIdBrandIdAndDate(35455, 1, LocalDateTime.parse("2020-08-15 00:00:00",formatter));
        assertNotNull(price);
    	assertEquals(priceEntities.get(0).getProductId(),price.getProductId());
    }

    @Test
    void testFindPriceByProductIdBrandIdAndDateNotFound() {
        Mockito.when(jpaPricesRepository.findPriceByProductIdBrandIdAndDate(35456, 1, LocalDateTime.parse("2020-08-15 00:00:00", formatter)))
        .thenReturn(new ArrayList<PriceEntity>(0));
        
    	Price price = pricesRepositoryImpl.findPriceByProductIdBrandIdAndDate(35456, 1, LocalDateTime.parse("2020-08-15 00:00:00",formatter));
        assertNull(price);
    }
    
}
