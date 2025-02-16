package com.pruebabcnc.infraestructure.repositories;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.pruebabcnc.domain.model.Price;
import com.pruebabcnc.domain.repository.PricesRepository;
import com.pruebabcnc.infraestructure.entities.PriceEntity;
import com.pruebabcnc.infraestructure.repositories.interfaces.JpaPricesRepository;
import com.pruebabcnc.infraestructure.utils.PriceMapper;

@Repository
public class PricesRepositoryImpl implements PricesRepository{

	private final JpaPricesRepository jpaPricesRepository;
	private final PriceMapper priceMapper = new PriceMapper();
	
	public PricesRepositoryImpl(JpaPricesRepository jpaPricesRepository) {
		super();
		this.jpaPricesRepository = jpaPricesRepository;
	}

	@Override
	public Price findPriceByProductIdBrandIdAndDate(Integer productId, Integer brandId, LocalDateTime date) {
		PriceEntity priceEntity = jpaPricesRepository.findPriceByProductIdBrandIdAndDate(productId, brandId, date);
		
		if(null!=priceEntity) {
			return priceMapper.mapEntityToPrice(priceEntity);
		}
		
		return null;
	}




}
