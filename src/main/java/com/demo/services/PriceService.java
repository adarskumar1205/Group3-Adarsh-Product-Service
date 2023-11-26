package com.demo.services;

import java.util.List;

import com.demo.dto.PriceDto;
<<<<<<< HEAD
import com.demo.exceptions.ResourceNotFoundException;
=======
>>>>>>> 9063362879ab31aedcce476500d8bfad93409ba8

public interface PriceService {

    PriceDto createPrice(PriceDto priceDTO);

<<<<<<< HEAD
    PriceDto getPriceByKey(String priceKey) throws ResourceNotFoundException;
=======
    PriceDto getPriceByKey(String priceKey);
>>>>>>> 9063362879ab31aedcce476500d8bfad93409ba8

    List<PriceDto> getAllPrices();


}
