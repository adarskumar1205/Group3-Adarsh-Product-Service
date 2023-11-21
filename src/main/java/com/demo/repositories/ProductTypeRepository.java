package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.ProductType;
import java.util.List;


@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
	ProductType findByProductTypeKey(String productTypeKey);
}
