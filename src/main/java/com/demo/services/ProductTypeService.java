package com.demo.services;

import java.util.List;

import com.demo.dto.ProductTypeDto;
import com.demo.entities.ProductType;

public interface ProductTypeService {
	ProductTypeDto createProductType(ProductTypeDto productTypeDto);
	ProductTypeDto getProductType(String productTypeKey);
	List<ProductTypeDto> getAllProductTypes();
	ProductTypeDto updateProductType(ProductTypeDto productTypeDto,String productTypeKey);
	ProductType deleteProductType(String productTypeKey);

}
