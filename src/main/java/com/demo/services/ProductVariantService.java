package com.demo.services;

import java.util.List;

import com.demo.dto.ProductVariantDto;
import com.demo.entities.ProductVariant;


public interface ProductVariantService {
	ProductVariantDto createProductVariant(ProductVariantDto productVariantDto);
	ProductVariantDto getProductVariant(String producVariantKey);
	List<ProductVariantDto> getAllProductVariants();
	ProductVariantDto updateProductVariant(ProductVariantDto productVariantDto,String producVariantKey);
	ProductVariant deleteProductVariant(String producVariantKey);
}
