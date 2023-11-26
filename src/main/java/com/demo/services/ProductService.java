package com.demo.services;

import java.util.List;

import com.demo.dto.ProductDto;
import com.demo.exceptions.ResourceNotFoundException;

public interface ProductService {
	 ProductDto createProduct(ProductDto productDto);
	 ProductDto getProductByKey(String productKey) throws ResourceNotFoundException;
	 List<ProductDto> getAllProducts();
	 List<ProductDto> getAllProductsByName(String name);
<<<<<<< HEAD
	 ProductDto updateProduct(ProductDto productDto,String productKey) throws ResourceNotFoundException;
	 void deleteProduct(String productKey) throws ResourceNotFoundException;
=======
	 ProductDto updateProduct(ProductDto productDto,String productKey);
	 ProductDto deleteProduct(String productKey);
>>>>>>> 9063362879ab31aedcce476500d8bfad93409ba8

}
