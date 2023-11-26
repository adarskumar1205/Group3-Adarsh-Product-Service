package com.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductCategoryDto {
	private long id;
	
	@NotBlank
	@Size(min=3,message = "Product Category Key should have atleast 3 characters")
	private String categoryKey;
	
	@NotBlank
	@Size(min=3,message = "Product Category Key should have atleast 3 characters")
	private String name;
	private String description;
	
	public ProductCategoryDto() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoryKey() {
		return categoryKey;
	}
	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
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


}
