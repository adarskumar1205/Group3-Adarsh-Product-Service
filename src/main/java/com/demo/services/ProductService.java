package com.demo.services;

import java.util.List;

import com.demo.dto.ProductDto;

public interface ProductService {
	 ProductDto createProduct(ProductDto productDto);
	 ProductDto getProductByKey(String productKey);
	 List<ProductDto> getAllProducts();
	 List<ProductDto> getAllProductsByName(String name);
	 ProductDto updateProduct(ProductDto productDto,String productKey);
	 ProductDto deleteProduct(String productKey);

}
