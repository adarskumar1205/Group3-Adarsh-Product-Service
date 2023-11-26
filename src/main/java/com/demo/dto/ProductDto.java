package com.demo.dto;

import java.util.Set;



import com.demo.entities.ProductCategory;

import com.demo.entities.ProductVariant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ProductDto {
	private long id;
	
	@NotEmpty
	@Size(min=3,message = "Product Key should have atleast 3 characters")
	private String productKey;
	
	@NotEmpty
	@Size(min=3,message = "Product name should have atleast 3 characters")
	private String name;
	private String description;
	
    private Set<ProductCategory> categories;
	
	private ProductVariant masterVariant;
	
	private Set<ProductVariant> variants;

	private String productTypeKey;
	
	public ProductDto() {
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
	public String getProductTypeKey() {
		return productTypeKey;
	}
	public void setProductTypeKey(String productTypeKey) {
		this.productTypeKey = productTypeKey;
	}
	

}
