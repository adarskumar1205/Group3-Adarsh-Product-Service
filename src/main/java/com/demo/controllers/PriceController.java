package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.PriceDto;
import com.demo.services.PriceService;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

	@Autowired
    private PriceService priceService;


	@PostMapping
    public ResponseEntity<PriceDto> createPrice(@RequestBody PriceDto priceDto) {
        PriceDto createdPrice = priceService.createPrice(priceDto);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<PriceDto>> getAllPrices() {
        List<PriceDto> priceDtoList = priceService.getAllPrices();
        return new ResponseEntity<>(priceDtoList, HttpStatus.OK);
    }
    
    @GetMapping("/{priceId}")
    public ResponseEntity<PriceDto> getPriceById(@PathVariable String priceKey) {
        PriceDto priceDto = priceService.getPriceByKey(priceKey);
        return new ResponseEntity<>(priceDto, HttpStatus.OK);
               
    }

}