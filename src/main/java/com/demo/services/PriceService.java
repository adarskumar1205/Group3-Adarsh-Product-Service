package com.demo.services;

import java.util.List;

import com.demo.dto.PriceDto;

public interface PriceService {

    PriceDto createPrice(PriceDto priceDTO);

    PriceDto getPriceByKey(String priceKey);

    List<PriceDto> getAllPrices();


}
