package com.demo.entities;

import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "products_types")
public class ProductType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String productTypeKey;

	@ElementCollection
	@CollectionTable(name = "AttributeDefination", joinColumns = {@JoinColumn(name = "product_Type_id", referencedColumnName = "id")})
	@MapKeyColumn(name = "DefinationName")
	@Column(name = "DefinationType")
	private Map<String, String> attributeDefination;
	
	public ProductType() {
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
