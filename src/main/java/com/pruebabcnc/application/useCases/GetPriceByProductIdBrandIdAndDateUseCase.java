package com.pruebabcnc.application.useCases;

import com.pruebabcnc.domain.model.Price;
import com.pruebabcnc.domain.repository.PricesRepository;
import com.pruebabcnc.exceptions.DateParserException;
import com.pruebabcnc.utils.CommonUtilities;

public class GetPriceByProductIdBrandIdAndDateUseCase {
    private final PricesRepository repository;

    public GetPriceByProductIdBrandIdAndDateUseCase(PricesRepository repository) {
        this.repository = repository;
    }

    public Price getPriceByProductIdBrandIdAndDate(Integer productId, Integer brandId, String date) throws DateParserException {
        return repository.findPriceByProductIdBrandIdAndDate(productId, brandId, CommonUtilities.parseFromString(date, CommonUtilities.YYYY_MM_DD_HH_MM_SS_HYPHEN_SEPARATOR));
    }
}
