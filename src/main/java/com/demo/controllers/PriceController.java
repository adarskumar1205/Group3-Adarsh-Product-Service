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
<<<<<<< HEAD
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.services.PriceService;

import jakarta.validation.Valid;

=======
import com.demo.services.PriceService;

>>>>>>> 9063362879ab31aedcce476500d8bfad93409ba8
@RestController
@RequestMapping("/api/prices")
public class PriceController {

	@Autowired
    private PriceService priceService;


	@PostMapping
<<<<<<< HEAD
    public ResponseEntity<PriceDto> createPrice(@Valid @RequestBody PriceDto priceDto) {
=======
    public ResponseEntity<PriceDto> createPrice(@RequestBody PriceDto priceDto) {
>>>>>>> 9063362879ab31aedcce476500d8bfad93409ba8
        PriceDto createdPrice = priceService.createPrice(priceDto);
        return new ResponseEntity<>(createdPrice, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<PriceDto>> getAllPrices() {
        List<PriceDto> priceDtoList = priceService.getAllPrices();
        return new ResponseEntity<>(priceDtoList, HttpStatus.OK);
    }
    
    @GetMapping("/{priceId}")
<<<<<<< HEAD
    public ResponseEntity<PriceDto> getPriceById(@PathVariable String priceKey) throws ResourceNotFoundException {
=======
    public ResponseEntity<PriceDto> getPriceById(@PathVariable String priceKey) {
>>>>>>> 9063362879ab31aedcce476500d8bfad93409ba8
        PriceDto priceDto = priceService.getPriceByKey(priceKey);
        return new ResponseEntity<>(priceDto, HttpStatus.OK);
               
    }

}