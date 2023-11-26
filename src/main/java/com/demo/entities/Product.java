package com.demo.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String productKey;
	
	private String name;
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProductType productType;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private Set<ProductCategory> categories;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProductVariant masterVariant;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ProductVariant> variants;
	
	
	public Product() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProductKey() {
		return productKey;
	}
	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<ProductCategory> getCategories() {
		return categories;
	}
	public void setCategories(Set<ProductCategory> categories) {
		this.categories = categories;
	}
	public ProductVariant getMasterVariant() {
		return masterVariant;
	}
	public void setMasterVariant(ProductVariant masterVariant) {
		this.masterVariant = masterVariant;
	}
	public Set<ProductVariant> getVariants() {
		return variants;
	}
	public void setVariants(Set<ProductVariant> variants) {
		this.variants = variants;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	

}
