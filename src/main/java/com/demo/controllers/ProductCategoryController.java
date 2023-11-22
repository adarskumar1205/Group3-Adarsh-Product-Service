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

import com.demo.dto.ProductCategoryDto;
import com.demo.entities.ProductCategory;
import com.demo.services.ProductCategoryService;

@RestController
@RequestMapping("/api/categories")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService productCategoryService;

	
	@PostMapping
	public ResponseEntity<ProductCategoryDto> createProductCategory(@RequestBody ProductCategoryDto categoryDto){
		ProductCategoryDto savedCategoryDto = productCategoryService.createProductCategory(categoryDto);
        return new ResponseEntity<>(savedCategoryDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/{categoryKey}")
    public ResponseEntity<ProductCategoryDto> getCategoryByKey(@PathVariable("categoryKey") String categoryKey){
		ProductCategoryDto categoryDto = productCategoryService.getProductCategory(categoryKey);
         return ResponseEntity.ok(categoryDto);
    }
	
	@GetMapping
	public ResponseEntity<List<ProductCategoryDto>> getAllCategories() {
		return ResponseEntity.ok(productCategoryService.getAllProductCategories());
	}
	
	@DeleteMapping("/{categoryKey}")
	public ResponseEntity<ProductCategoryDto> deleteCategoryByKey(@PathVariable("categoryKey") String categoryKey) {
		ProductCategoryDto category = productCategoryService.deleteProductCategory(categoryKey);
		return ResponseEntity.ok(category);
	}
	
	@PutMapping("/{categoriesKey}")
	public ResponseEntity<ProductCategoryDto> updateCategoryByKey(@RequestBody ProductCategoryDto categoryDto,
														@PathVariable("categoriesKey") String categoryKey) {
		ProductCategoryDto updateCategoryDto = productCategoryService.updateProductCategory(categoryDto,categoryKey);
		if (updateCategoryDto != null) {
	        return new ResponseEntity<>(updateCategoryDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

}
