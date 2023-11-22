package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.ProductDto;
import com.demo.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
		ProductDto savedProductDto = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProductDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/{productKey}")
    public ResponseEntity<ProductDto> getProductByKey(@PathVariable("productKey") String productKey){
        return new ResponseEntity<>(productService.getProductByKey(productKey), HttpStatus.FOUND);
    }
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@PutMapping("/{productKey}")
	public ResponseEntity<ProductDto> updateProductByKey(@RequestBody ProductDto productDto,
														@PathVariable("productKey") String productKey) {
		ProductDto updateProductDto = productService.updateProduct(productDto,productKey);
		if (updateProductDto != null) {
	        return new ResponseEntity<>(updateProductDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/{productKey}")
	public ResponseEntity<ProductDto> deleteProductByKey(@PathVariable("productKey") String productKey) {
		ProductDto productDto = productService.deleteProduct(productKey);
		return ResponseEntity.ok(productDto);
	}
	
}
