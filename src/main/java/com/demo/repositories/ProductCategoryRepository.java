package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.ProductCategory;
import java.util.List;


@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
	ProductCategory  findByCategoryKey(String categoryKey);;

}
