package com.pruebabcnc.infraestructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pruebabcnc.infraestructure.entities.PriceEntity;
import com.pruebabcnc.infraestructure.repositories.interfaces.JpaPricesRepository;

@DataJpaTest
class JpaRepositoryTests {
    @Autowired
    private JpaPricesRepository jpaPricesRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private PriceEntity priceEntity;
    @BeforeEach
    void setUp() {
    	priceEntity = new PriceEntity();
    	priceEntity.setBrandId(1);
    	priceEntity.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
    	priceEntity.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
    	priceEntity.setPriceList(1);
    	priceEntity.setProductId(35455);
    	priceEntity.setPriority(0);
    	priceEntity.setPrice(35.50);
    	priceEntity.setCurrency("EUR");
    	
    	jpaPricesRepository.save(priceEntity);
    }
    @Test
    void testFindPriceByProductIdBrandIdAndDateFoundInDataBase() {
    	List<PriceEntity> priceEntityFound = jpaPricesRepository.findPriceByProductIdBrandIdAndDate(35455, 1, LocalDateTime.parse("2020-08-15 00:00:00",formatter));
        assertEquals(1,priceEntityFound.size());
    }
    @Test
    void testFindPriceByProductIdBrandIdAndDateNotFoundInDatabase() {
    	List<PriceEntity> priceEntityFound = jpaPricesRepository.findPriceByProductIdBrandIdAndDate(35456, 1, LocalDateTime.parse("2020-08-15 00:00:00",formatter));
        assertEquals(0,priceEntityFound.size());
    }
}
