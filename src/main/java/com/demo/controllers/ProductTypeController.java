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

import com.demo.dto.ProductTypeDto;
import com.demo.entities.ProductType;
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.services.ProductTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productTypes")
public class ProductTypeController {

	@Autowired
	private ProductTypeService productTypeService;

	@PostMapping
	public ResponseEntity<ProductTypeDto> createProductType(@Valid @RequestBody ProductTypeDto productTypeDto) {
		ProductTypeDto savedProductTypeDto = productTypeService.createProductType(productTypeDto);
		return new ResponseEntity<>(savedProductTypeDto, HttpStatus.CREATED);
	}

	@GetMapping("/{productTypeKey}")
	public ResponseEntity<ProductTypeDto> getProductTypeByKey(@PathVariable("productTypeKey") String productTypeKey) throws ResourceNotFoundException {
		ProductTypeDto productTypeDto = productTypeService.getProductType(productTypeKey);
		return ResponseEntity.ok(productTypeDto);
	}

	@GetMapping
	public ResponseEntity<List<ProductTypeDto>> getAllProductTypes() {
		return ResponseEntity.ok(productTypeService.getAllProductTypes());

	}

	@DeleteMapping("/{productTypeKey}")
	public ResponseEntity<String> deleteProductTypeByKey(@PathVariable("productTypeKey") String productTypeKey) throws ResourceNotFoundException {
		productTypeService.deleteProductType(productTypeKey);
		return ResponseEntity.ok("type deleted succesfully");
	}
	
	@PutMapping("/{productTypeKey}")
	public ResponseEntity<ProductTypeDto> updateProductTypeByKey(@RequestBody ProductTypeDto productTypeDto,
														@PathVariable("productTypeKey") String productTypeKey) throws ResourceNotFoundException {
		ProductTypeDto updateProductTypeDto = productTypeService.updateProductType(productTypeDto,productTypeKey);
		if (updateProductTypeDto != null) {
	        return new ResponseEntity<>(updateProductTypeDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
}