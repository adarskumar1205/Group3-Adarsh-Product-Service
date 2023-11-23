package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.dto.ProductDto;
import com.demo.entities.Product;
import com.demo.entities.ProductVariant;

import java.util.List;


@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>{
	Product findByProductKey(String productKey);
	
	
	List<Product> findByName(String name);
}
