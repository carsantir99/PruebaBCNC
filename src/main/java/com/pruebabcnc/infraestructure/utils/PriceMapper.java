package com.pruebabcnc.infraestructure.utils;

import org.springframework.stereotype.Component;

import com.pruebabcnc.domain.model.Price;
import com.pruebabcnc.infraestructure.entities.PriceEntity;

@Component
public class PriceMapper {
    public Price mapEntityToPrice(PriceEntity priceEntity) {
        return new Price(
            priceEntity.getBrandId(),
            priceEntity.getStartDate(),
            priceEntity.getEndDate(),
            priceEntity.getPriceList(),
            priceEntity.getProductId(),
            priceEntity.getPriority(),
            priceEntity.getPrice(),
            priceEntity.getCurrency()
        );
    } 
}
