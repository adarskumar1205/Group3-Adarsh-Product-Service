package com.demo.services;

import java.util.List;

import com.demo.dto.ProductDto;

public interface ProductService {
	 ProductDto createProduct(ProductDto productDto);
	 ProductDto getProductByKey(String productKey);
	 List<ProductDto> getAllProducts();
	 ProductDto updateProduct(ProductDto productDto,String productKey);
	 void deleteProduct(String productKey);

}
