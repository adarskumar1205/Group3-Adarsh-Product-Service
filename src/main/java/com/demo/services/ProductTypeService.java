package com.demo.services;

import java.util.List;

import com.demo.dto.ProductTypeDto;
import com.demo.entities.ProductType;
import com.demo.exceptions.ResourceNotFoundException;

public interface ProductTypeService {
	ProductTypeDto createProductType(ProductTypeDto productTypeDto);
	ProductTypeDto getProductType(String productTypeKey) throws ResourceNotFoundException;
	List<ProductTypeDto> getAllProductTypes();
	ProductTypeDto updateProductType(ProductTypeDto productTypeDto,String productTypeKey) throws ResourceNotFoundException;
	void deleteProductType(String productTypeKey) throws ResourceNotFoundException;

}
