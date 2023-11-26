package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Price;



@Repository
public interface PriceRepository extends JpaRepository<Price, Long>  {
	Price findByPriceKey(String priceKey);
}
