package com.demo.dto;

import java.util.Set;

import com.demo.entities.Price;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

public class ProductVariantDto {
	private long id;
	
	@Column(nullable = false, unique = true)
	private String productVariantKey;
	
	private int sku;

	@OneToMany
	private Set<Price> prices;
	
	
	public ProductVariantDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductVariantKey() {
		return productVariantKey;
	}

	public void setProductVariantKey(String productVariantKey) {
		this.productVariantKey = productVariantKey;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public Set<Price> getPrices() {
		return prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}
	
	

}
