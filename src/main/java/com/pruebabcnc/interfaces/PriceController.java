package com.pruebabcnc.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebabcnc.application.dto.PriceDTO;
import com.pruebabcnc.application.usecases.GetPriceByProductIdBrandIdAndDateUseCase;
import com.pruebabcnc.exceptions.DateParserException;
import com.pruebabcnc.exceptions.NotFoundException;

@RestController
public class PriceController {
    private final GetPriceByProductIdBrandIdAndDateUseCase useCase;

    public PriceController(GetPriceByProductIdBrandIdAndDateUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/prices")
    public ResponseEntity<PriceDTO> getPrice(
            @RequestParam Integer productId,@RequestParam Integer brandId,@RequestParam String date) throws DateParserException, NotFoundException {
        return ResponseEntity.ok(useCase.getPriceByProductIdBrandIdAndDate(productId, brandId, date));
    }
}
