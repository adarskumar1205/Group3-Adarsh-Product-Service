package com.demo.services;

import java.util.List;

import com.demo.dto.ProductCategoryDto;

public interface ProductCategoryService {
	ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto);
	ProductCategoryDto getProductCategory(String productCategoryKey);
	List<ProductCategoryDto> getAllProductCategories();
	ProductCategoryDto updateProductCategory(ProductCategoryDto productCategoryDto,String productCategoryKey);
	ProductCategoryDto deleteProductCategory(String productCategoryKey);
}
