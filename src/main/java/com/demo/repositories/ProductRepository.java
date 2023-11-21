package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Product;
import java.util.List;


@Repository
public interface ProductRepository  extends JpaRepository<Product, Long>{
	Product findByProductKey(String productKey);
}
