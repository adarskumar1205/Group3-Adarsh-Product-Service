package com.demo.entities;

import java.util.Map;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_variant")
public class ProductVariant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String productVariantKey;
	
	private int sku;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Price> prices;
	
	@ElementCollection
	@CollectionTable(name = "Attributes", joinColumns = {@JoinColumn(name = "products_variants_id", referencedColumnName = "id")})
	@MapKeyColumn(name = "DefinationName")
	@Column(name = "DefinationType")
	private Map<String, String> attributes;
	
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
