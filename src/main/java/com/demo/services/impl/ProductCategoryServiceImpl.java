package com.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.ProductCategoryDto;
import com.demo.dto.ProductTypeDto;
import com.demo.dto.ProductVariantDto;
import com.demo.entities.ProductCategory;
import com.demo.entities.ProductVariant;
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.repositories.ProductCategoryRepository;
import com.demo.repositories.ProductVariantRepository;
import com.demo.services.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto) {
		// TODO Auto-generated method stub
		ProductCategory productCategory = mapper.map(productCategoryDto, ProductCategory.class);
		
		
		
		return mapper.map(productCategoryRepository.save(productCategory), ProductCategoryDto.class);
	}

	@Override
	public ProductCategoryDto getProductCategory(String productCategoryKey) {
		// TODO Auto-generated method stub
		ProductCategory productCategory = productCategoryRepository.findByCategoryKey(productCategoryKey);
		
		if(productCategory!=null) {
			return mapper.map(productCategory, ProductCategoryDto.class);
		}
		else
			throw new ResourceNotFoundException("ProductCategory", "ProducCategoryKey", productCategoryKey);
		
	}

	@Override
	public List<ProductCategoryDto> getAllProductCategories() {
		// TODO Auto-generated method stub
		List<ProductCategoryDto> list = productCategoryRepository.findAll()
											.stream()
											.map((productCategory)->mapper.map(productCategory, ProductCategoryDto.class))
											.collect(Collectors.toList());
		return list;
	}

	@Override
	public ProductCategoryDto updateProductCategory(ProductCategoryDto productCategoryDto, String productCategoryKey) {
		// TODO Auto-generated method stub
		ProductCategory productCategory = productCategoryRepository.findByCategoryKey(productCategoryKey);
		
		if(productCategory!=null) {
			productCategory.setCategoryKey(productCategoryDto.getCategoryKey());
			productCategory.setName(productCategoryDto.getName());
			productCategory.setDescription(productCategoryDto.getDescription());
			
			ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
			
			return mapper.map(savedProductCategory,ProductCategoryDto.class);
		}
		else
			throw new ResourceNotFoundException("ProductCategory", "ProducCategoryKey", productCategoryKey);
	}

	@Override
	public ProductCategoryDto deleteProductCategory(String productCategoryKey) {
		// TODO Auto-generated method stub
		ProductCategory productCategory = productCategoryRepository.findByCategoryKey(productCategoryKey);
		
		if(productCategory!=null) {
			productCategoryRepository.delete(productCategory);
			
			return mapper.map(productCategory,ProductCategoryDto.class);
		}
		else
			throw new ResourceNotFoundException("ProductCategory", "ProducCategoryKey", productCategoryKey);
	}

}
