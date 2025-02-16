package com.pruebabcnc.domain.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
	private Integer product;
	private Integer brand;
	private Integer rateNumber;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double priceValue;
	private String currency;
	private Integer priority;
	
	public Price() {
		
	}
	
	public Price(Integer brand, LocalDateTime startDate, LocalDateTime endDate, Integer rateNumber, Integer product,
			 Double priceValue, String currency, Integer priority) {
		this.brand = brand;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rateNumber = rateNumber;
		this.product = product;
		this.priceValue = priceValue;
		this.currency = currency;
		this.priority= priority;
	}
}
