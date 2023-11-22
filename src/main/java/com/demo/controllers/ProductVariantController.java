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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.ProductDto;
import com.demo.dto.ProductVariantDto;
import com.demo.services.ProductVariantService;

@RestController
@RequestMapping("/api/productVariants")
public class ProductVariantController {
	
	@Autowired
	private ProductVariantService productVariantService;
	
	@PostMapping
    public ResponseEntity<ProductVariantDto> createProductVariant(@RequestBody ProductVariantDto productVariantDTO) {
        ProductVariantDto createdProductVariant = productVariantService.createProductVariant(productVariantDTO);
        return new ResponseEntity<>(createdProductVariant, HttpStatus.CREATED);
    } 
	
	@GetMapping("/{productVariantKey}")
	public ResponseEntity<ProductVariantDto> getProductVariantByKey(@PathVariable("productVariantKey") String productVariantKey) {
		ProductVariantDto productVariantDto = productVariantService.getProductVariant(productVariantKey);
		return ResponseEntity.ok(productVariantDto);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductVariantDto>> getAllProductVariant() {
		return ResponseEntity.ok(productVariantService.getAllProductVariants());

	}
	
	@PutMapping("/{productVariantKey}")
	public ResponseEntity<ProductVariantDto> updateProductVaraintByKey(@RequestBody ProductVariantDto productVariantDto,
														@PathVariable("productVariantKey") String productVariantKey) {
		ProductVariantDto updateProductVariantDto = productVariantService.updateProductVariant(productVariantDto,productVariantKey);
		if (updateProductVariantDto != null) {
	        return new ResponseEntity<>(updateProductVariantDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/{productVariantKey}")
	public ResponseEntity<String> deleteProductByKey(@PathVariable("productVariantKey") String productVariantKey) {
		productVariantService.deleteProductVariant(productVariantKey);
		return  ResponseEntity.ok("variant deleted successfully");
	}
	

}
