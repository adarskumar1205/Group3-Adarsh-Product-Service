package com.demo.dto;

import java.util.Map;
import java.util.Set;

import com.demo.entities.Price;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductVariantDto {
	private long id;
	
	@NotBlank
	@Size(min=3,message = "Product Variant Key should have atleast 3 characters")
	private String productVariantKey;
	
	@NotBlank
	private int sku;
	
	private Set<Price> prices;
	
	@ElementCollection
	@CollectionTable(name = "Attributes", joinColumns = {@JoinColumn(name = "products_variants_id", referencedColumnName = "id")})
	@MapKeyColumn(name = "DefinationName")
	@Column(name = "DefinationType")
	private Map<String, String> attributes;
	
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

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
	

}
