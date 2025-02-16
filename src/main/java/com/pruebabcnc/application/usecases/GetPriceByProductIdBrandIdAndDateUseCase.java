package com.pruebabcnc.application.usecases;

import org.springframework.stereotype.Service;

import com.pruebabcnc.application.dto.PriceDTO;
import com.pruebabcnc.domain.model.Price;
import com.pruebabcnc.domain.repository.PricesRepository;
import com.pruebabcnc.exceptions.DateParserException;
import com.pruebabcnc.exceptions.NotFoundException;
import com.pruebabcnc.utils.CommonUtilities;

@Service
public class GetPriceByProductIdBrandIdAndDateUseCase {
    private final PricesRepository repository;

    public GetPriceByProductIdBrandIdAndDateUseCase(PricesRepository repository) {
        this.repository = repository;
    }

    public PriceDTO getPriceByProductIdBrandIdAndDate(Integer productId, Integer brandId, String date) throws DateParserException, NotFoundException {
        Price price = repository.findPriceByProductIdBrandIdAndDate(productId, brandId, CommonUtilities.parseFromString(date, CommonUtilities.YYYY_MM_DD_HH_MM_SS_HYPHEN_SEPARATOR));
        if(null!=price) {
        	return new PriceDTO(price);
        }else {
        	throw new NotFoundException("No results found for the filters provided");
        }
    }
}
