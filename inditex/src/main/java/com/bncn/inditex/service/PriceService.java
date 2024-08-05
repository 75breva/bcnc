package com.bncn.inditex.service;

import com.bncn.inditex.dto.Price;
import com.bncn.inditex.model.PriceJpa;

import com.bncn.inditex.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;
    public List<Price> findPrices( Integer productId, Integer brandId, String applicationDate) {


        List<PriceJpa> priceJpaList = priceRepository.findAllPricesbyDate(productId,brandId, Timestamp.valueOf(applicationDate));

        List<Price> priceList = new ArrayList<>();


        return priceList;
    }

}