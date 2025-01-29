package com.pruebabcnc.domain.model;

import java.time.LocalDateTime;

public class Price {
	private Integer product;
	private Integer brand;
	private Integer rateNumber;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double priceValue;
	private String currency;
	
	public Price() {
		
	}
	
	public Price(Integer brand, LocalDateTime startDate, LocalDateTime endDate, Integer rateNumber, Integer product,
			 Double priceValue, String currency) {
		this.brand = brand;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rateNumber = rateNumber;
		this.product = product;
		this.priceValue = priceValue;
		this.currency = currency;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	public Integer getRateNumber() {
		return rateNumber;
	}

	public void setRateNumber(Integer rateNumber) {
		this.rateNumber = rateNumber;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Double getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(Double priceValue) {
		this.priceValue = priceValue;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
	
}
