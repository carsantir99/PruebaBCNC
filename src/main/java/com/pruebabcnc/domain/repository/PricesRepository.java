package com.pruebabcnc.domain.repository;

import java.time.LocalDateTime;

import com.pruebabcnc.domain.model.Price;

public interface PricesRepository {
	Price findPriceByProductIdBrandIdAndDate(Integer productId,Integer brandId,LocalDateTime date);
}
