package com.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products_variants")
public class ProductVariant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String productVariantKey;
	
	private int sku;

	public ProductVariant() {
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
	
	

}
