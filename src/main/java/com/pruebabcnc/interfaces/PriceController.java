package com.pruebabcnc.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebabcnc.application.usecases.GetPriceByProductIdBrandIdAndDateUseCase;
import com.pruebabcnc.domain.model.Price;
import com.pruebabcnc.exceptions.DateParserException;
import com.pruebabcnc.exceptions.NotFoundException;

@RestController
public class PriceController {
    private final GetPriceByProductIdBrandIdAndDateUseCase useCase;

    public PriceController(GetPriceByProductIdBrandIdAndDateUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/prices")
    public Price getPrice(
            @RequestParam Integer productId,@RequestParam Integer brandId,@RequestParam String date) throws DateParserException, NotFoundException {
        return useCase.getPriceByProductIdBrandIdAndDate(productId, brandId, date);
    }
}
