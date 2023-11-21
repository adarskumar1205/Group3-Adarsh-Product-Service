package com.demo.dto;

import java.util.Map;

public class ProductTypeDto {
	private long id;

	private String productTypeKey;

	private Map<String, String> attributeDefination;
	
	public ProductTypeDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductTypeKey() {
		return productTypeKey;
	}

	public void setProductTypeKey(String productTypeKey) {
		this.productTypeKey = productTypeKey;
	}

	public Map<String, String> getAttributeDefination() {
		return attributeDefination;
	}

	public void setAttributeDefination(Map<String, String> attributeDefination) {
		this.attributeDefination = attributeDefination;
	}

}
