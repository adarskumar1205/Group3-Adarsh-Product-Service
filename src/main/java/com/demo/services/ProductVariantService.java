package com.demo.services;

import java.util.List;

import com.demo.dto.ProductVariantDto;


public interface ProductVariantService {
	ProductVariantDto createProductVariant(ProductVariantDto productVariantDto);
	ProductVariantDto getProductVariant(String producVariantKey);
	List<ProductVariantDto> getAllProductVariants();
	ProductVariantDto updateProductVariant(ProductVariantDto productVariantDto,String producVariantKey);
	ProductVariantDto deleteProductVariant(String producVariantKey);
}
