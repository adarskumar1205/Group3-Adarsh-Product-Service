package com.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.ProductDto;
import com.demo.dto.ProductTypeDto;
import com.demo.entities.Product;
import com.demo.entities.ProductType;
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.repositories.ProductRepository;
import com.demo.repositories.ProductTypeRepository;
import com.demo.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ProductDto createProduct(ProductDto productDto) {
		
		// TODO Auto-generated method stub
		ProductType productType = productTypeRepository.findByProductTypeKey(productDto.getProductTypeKey());
		
		Product product = mapper.map(productDto, Product.class);
		
		product.setProductType(productType);
	
		return mapper.map(productRepository.save(product), ProductDto.class);
	
	}

	@Override
	public ProductDto getProductByKey(String productKey) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Product product = productRepository.findByProductKey(productKey);
		
		if(product!=null) {
			return mapper.map(product,ProductDto.class);
		}
		else
			throw new ResourceNotFoundException("Product", "ProductKey", productKey);
		
	}

	@Override
	public List<ProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<ProductDto> list = productRepository.findAll()
								.stream()
								.map((product)->mapper.map(product, ProductDto.class))
								.collect(Collectors.toList());
		
		return list;
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto,String productKey) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Product product = productRepository.findByProductKey(productKey);

		if (product != null) {
			product.setProductKey(productDto.getProductKey());
			product.setName(productDto.getName());
			product.setDescription(productDto.getDescription());
			product.setCategories(productDto.getCategories());
			product.setProductType(productTypeRepository.findByProductTypeKey(productDto.getProductTypeKey()));
			product.setMasterVariant(productDto.getMasterVariant());
			product.setVariants(productDto.getVariants());
			Product savedProduct = productRepository.save(product);

			return mapper.map(savedProduct, ProductDto.class);
		}
		else
			throw new ResourceNotFoundException("Product", "ProducKey", productKey);
	}

	@Override
	public void deleteProduct(String productKey) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Product product = productRepository.findByProductKey(productKey);
		
		if(product!=null) {
			productRepository.delete(product);
			
		}
		else
			throw new ResourceNotFoundException("Product", "ProducKey", productKey);
		
	}

	@Override
	public List<ProductDto> getAllProductsByName(String name) {
		// TODO Auto-generated method stub
		List<ProductDto> list = productRepository.findByName(name)
								.stream()
								.map((product)->mapper.map(product, ProductDto.class))
								.collect(Collectors.toList());

		return list;
	}

	

	
}
