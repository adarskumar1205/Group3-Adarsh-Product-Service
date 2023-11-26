package com.demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PriceDto {
	private long id;
	
	@NotBlank
	@Size(min=3,message = "Price Key should have atleast 3 characters")
	private String priceKey;
	
	@NotBlank
	private int sku;
	@NotBlank
	private long centAmount;
	@NotBlank
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
