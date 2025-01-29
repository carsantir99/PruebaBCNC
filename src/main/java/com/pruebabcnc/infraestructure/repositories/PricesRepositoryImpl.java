package com.pruebabcnc.infraestructure.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
		Optional<List<PriceEntity>> pricesEntityList = jpaPricesRepository.findPriceByProductIdBrandIdAndDate(productId, brandId, date);
		
		if(!pricesEntityList.isEmpty() && !pricesEntityList.get().isEmpty()) {
			return pricesEntityList.get().stream().findFirst().map(priceMapper::mapEntityToPrice).get();
		}
		
		return null;
	}




}
