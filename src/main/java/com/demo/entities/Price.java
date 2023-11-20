package com.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prices")
public class Price {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String priceKey;
	
	private int sku;
	private long centAmount;
	private String currency;
	public Price() {
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
