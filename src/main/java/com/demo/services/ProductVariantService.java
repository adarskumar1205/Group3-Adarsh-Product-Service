package com.demo.services;

import java.util.List;

import com.demo.dto.ProductVariantDto;
import com.demo.entities.ProductVariant;
import com.demo.exceptions.ResourceNotFoundException;


public interface ProductVariantService {
	ProductVariantDto createProductVariant(ProductVariantDto productVariantDto);
	ProductVariantDto getProductVariant(String producVariantKey) throws ResourceNotFoundException;
	List<ProductVariantDto> getAllProductVariants();
	ProductVariantDto updateProductVariant(ProductVariantDto productVariantDto,String producVariantKey) throws ResourceNotFoundException;
	ProductVariant deleteProductVariant(String producVariantKey) throws ResourceNotFoundException;
}
