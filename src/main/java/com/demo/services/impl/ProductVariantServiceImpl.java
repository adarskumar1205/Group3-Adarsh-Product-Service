package com.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.dto.ProductVariantDto;

import com.demo.entities.ProductVariant;
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.repositories.ProductVariantRepository;
import com.demo.services.ProductVariantService;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {


	@Autowired
	private ProductVariantRepository productVariantRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ProductVariantDto createProductVariant(ProductVariantDto productVariantDto) {
		// TODO Auto-generated method stub
		ProductVariant productVariant = mapper.map(productVariantDto, ProductVariant.class);
		
		
		
		return mapper.map(productVariantRepository.save(productVariant), ProductVariantDto.class);
	}

	@Override
	public ProductVariantDto getProductVariant(String producVariantKey) {
		// TODO Auto-generated method stub
		
		ProductVariant productVariant = productVariantRepository.findByProductVariantKey(producVariantKey);
		
		if(productVariant!=null) {
			return mapper.map(productVariant, ProductVariantDto.class);
		}
		else
			throw new ResourceNotFoundException("ProductVariant", "ProducVariantKey", producVariantKey);
		
	}

	@Override
	public List<ProductVariantDto> getAllProductVariants() {
		// TODO Auto-generated method stub
		
		List<ProductVariantDto> list = productVariantRepository.findAll()
										.stream()
										.map((productVariant)->mapper.map(productVariant, ProductVariantDto.class))
										.collect(Collectors.toList());
		return list;
	}

	@Override
	public ProductVariantDto updateProductVariant(ProductVariantDto productVariantDto, String producVariantKey) {
		// TODO Auto-generated method stub
		ProductVariant productVariant = productVariantRepository.findByProductVariantKey(producVariantKey);
		
		if(productVariant!=null) {
			productVariant.setProductVariantKey(productVariantDto.getProductVariantKey());
			productVariant.setSku(productVariantDto.getSku());
			productVariant.setPrices(productVariantDto.getPrices());
			productVariant.setAttributes(productVariant.getAttributes());
			
			ProductVariant savedProductVariant = productVariantRepository.save(productVariant);
			
			return mapper.map(savedProductVariant,ProductVariantDto.class);
		}
		else {
			throw new ResourceNotFoundException("ProductVariant", "ProducVariantKey", producVariantKey);
		}
		
	}

	@Override
	public ProductVariant deleteProductVariant(String producVariantKey) {
		// TODO Auto-generated method stub
		ProductVariant productVariant = productVariantRepository.findByProductVariantKey(producVariantKey);
		
		if(productVariant!=null) {
			productVariantRepository.delete(productVariant);
			return productVariant;
			
		}
		else {
			throw new ResourceNotFoundException("ProductVariant", "ProducVariantKey", producVariantKey);
		}
		
	}
	
	

}
