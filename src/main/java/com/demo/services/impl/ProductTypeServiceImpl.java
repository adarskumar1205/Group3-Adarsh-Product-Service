package com.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.ProductTypeDto;
import com.demo.dto.ProductVariantDto;
import com.demo.entities.ProductType;
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.repositories.ProductTypeRepository;
import com.demo.services.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ProductTypeDto createProductType(ProductTypeDto productTypeDto) {
		// TODO Auto-generated method stub
		ProductType productType = mapper.map(productTypeDto, ProductType.class);
		
		return mapper.map(productTypeRepository.save(productType),ProductTypeDto.class);
	}

	@Override
	public ProductTypeDto getProductType(String productTypeKey) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		ProductType productType = productTypeRepository.findByProductTypeKey(productTypeKey);
		
		if(productType!=null) {
			return mapper.map(productType, ProductTypeDto.class);
		}
		else
			throw new ResourceNotFoundException("ProductType", "ProducTypeKey", productTypeKey);
		
	}

	@Override
	public List<ProductTypeDto> getAllProductTypes() {
		// TODO Auto-generated method stub
		
		List<ProductTypeDto> list = productTypeRepository.findAll()
									.stream()
									.map((productType)->mapper.map(productType, ProductTypeDto.class))
									.collect(Collectors.toList());

		return list;
	}

	@Override
	public ProductTypeDto updateProductType(ProductTypeDto productTypeDto, String productTypeKey) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		ProductType productType = productTypeRepository.findByProductTypeKey(productTypeKey);
		
		if(productType!=null) {
			productType.setProductTypeKey(productTypeDto.getProductTypeKey());
			productType.setAttributeDefination(productTypeDto.getAttributeDefination());
			
			ProductType savedProductType = productTypeRepository.save(productType);
			
			return mapper.map(savedProductType, ProductTypeDto.class);
		}
		else
			throw new ResourceNotFoundException("ProductType", "ProducTypeKey", productTypeKey);
	}

	@Override
	public void deleteProductType(String productTypeKey) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		ProductType productType = productTypeRepository.findByProductTypeKey(productTypeKey);
		
		if(productType!=null) {
			productTypeRepository.delete(productType);
			
			
		}
		else
			throw new ResourceNotFoundException("ProductType", "ProducTypeKey", productTypeKey);
	}

	
}
