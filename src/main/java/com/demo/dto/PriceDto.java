package com.demo.dto;

import jakarta.persistence.Column;

public class PriceDto {
	private long id;
	
	@Column(nullable = false, unique = true)
	private String priceKey;
	
	private int sku;
	private long centAmount;
	private String currency;
	
	
	public PriceDto() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPriceKey() {
		return priceKey;
	}
	public void setPriceKey(String priceKey) {
		this.priceKey = priceKey;
	}
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	public long getCentAmount() {
		return centAmount;
	}
	public void setCentAmount(long centAmount) {
		this.centAmount = centAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	

}
