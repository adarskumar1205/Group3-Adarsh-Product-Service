package com.demo.services;

import java.util.List;

import com.demo.dto.ProductCategoryDto;
import com.demo.exceptions.ResourceNotFoundException;

public interface ProductCategoryService {
	ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto);
	ProductCategoryDto getProductCategory(String productCategoryKey) throws ResourceNotFoundException;
	List<ProductCategoryDto> getAllProductCategories();
	ProductCategoryDto updateProductCategory(ProductCategoryDto productCategoryDto,String productCategoryKey) throws ResourceNotFoundException;
	ProductCategoryDto deleteProductCategory(String productCategoryKey) throws ResourceNotFoundException;
}
