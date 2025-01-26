package com.pruebabcnc.domain.repository;

import com.pruebabcnc.domain.model.Price;

public interface PricesRepository {
	Price findPriceByProductIdBrandIdAndDate(Integer productId,Integer brandId,String date);
}
