package com.pruebabcnc.application.dto;

import java.time.LocalDateTime;

import com.pruebabcnc.domain.model.Price;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceDTO {
	private Integer productId;
	private Integer brandId;
	private Integer productList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double price;
	private String currency;
	
	public PriceDTO() {
		
	}
	
	public PriceDTO(Price price) {
		this.productId = price.getProduct();
		this.brandId = price.getBrand();
		this.productList = price.getRateNumber();
		this.startDate = price.getStartDate();
		this.endDate = price.getEndDate();
		this.price = price.getPriceValue();
		this.currency = price.getCurrency();
	}
}
