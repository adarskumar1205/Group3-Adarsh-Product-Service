package com.demo.services.impl;

import com.demo.dto.PriceDto;

import com.demo.entities.Price;
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.repositories.PriceRepository;
import com.demo.services.PriceService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
    private PriceRepository priceRepository;
    
	@Autowired
	private ModelMapper mapper;

    @Override
    public PriceDto createPrice(PriceDto priceDto) {
        Price price = mapper.map(priceDto, Price.class);
        Price savedPrice = priceRepository.save(price);
        return mapper.map(savedPrice, PriceDto.class);
    }

    @Override
<<<<<<< HEAD
    public PriceDto getPriceByKey(String priceKey) throws ResourceNotFoundException {
=======
    public PriceDto getPriceByKey(String priceKey) {
>>>>>>> 9063362879ab31aedcce476500d8bfad93409ba8
        Price price = priceRepository.findByPriceKey(priceKey);
        
        		if(price!=null) {
        			return mapper.map(price,PriceDto.class);
        		}
        		else
        			throw new ResourceNotFoundException("Price", "PriceKy", priceKey);		
    }

    @Override
    public List<PriceDto> getAllPrices() {
        List<Price> prices = priceRepository.findAll();
        return prices.stream()
                .map(price -> mapper.map(price, PriceDto.class))
                .collect(Collectors.toList());
    }

	
	


}