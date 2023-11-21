package com.demo.services;

import java.util.List;

import com.demo.dto.ProductTypeDto;

public interface ProductTypeService {
	ProductTypeDto createProductType(ProductTypeDto productTypeDto);
	ProductTypeDto getProductType(String productTypeKey);
	List<ProductTypeDto> getAllProductTypes();
	ProductTypeDto updateProductType(ProductTypeDto productTypeDto,String productTypeKey);
	ProductTypeDto deleteProductType(String productTypeKey);

}
