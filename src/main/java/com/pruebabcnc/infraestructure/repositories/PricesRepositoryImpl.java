package com.pruebabcnc.infraestructure.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pruebabcnc.domain.model.Price;
import com.pruebabcnc.domain.repository.PricesRepository;
import com.pruebabcnc.infraestructure.entities.PriceEntity;
import com.pruebabcnc.infraestructure.repositories.interfaces.JpaPricesRepository;
import com.pruebabcnc.infraestructure.utils.PriceMapper;

@Repository
public class PricesRepositoryImpl implements PricesRepository{

	private final JpaPricesRepository jpaPricesRepository;
	private final PriceMapper priceMapper;
	
	public PricesRepositoryImpl(JpaPricesRepository jpaPricesRepository, PriceMapper priceMapper) {
		super();
		this.jpaPricesRepository = jpaPricesRepository;
		this.priceMapper = priceMapper;
	}

	@Override
	public Price findPriceByProductIdBrandIdAndDate(Integer productId, Integer brandId, LocalDateTime date) {
		List<PriceEntity> pricesEntityList = jpaPricesRepository.findPriceByProductIdBrandIdAndDate(productId, brandId, date);
		
		if(null != pricesEntityList) {
			return pricesEntityList.stream().findFirst().map(priceMapper::mapEntityToPrice).get();
		}
		
		return null;
	}




}
