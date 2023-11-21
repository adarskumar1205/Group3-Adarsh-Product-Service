package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.ProductVariant;
import java.util.List;


@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
	ProductVariant findByProductVariantKey(String productVariantKey);
}
