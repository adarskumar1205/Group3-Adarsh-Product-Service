package com.demo.services;

import java.util.List;

import com.demo.dto.PriceDto;

import com.demo.exceptions.ResourceNotFoundException;

public interface PriceService {

    PriceDto createPrice(PriceDto priceDTO);

    PriceDto getPriceByKey(String priceKey) throws ResourceNotFoundException;

    List<PriceDto> getAllPrices();


}
