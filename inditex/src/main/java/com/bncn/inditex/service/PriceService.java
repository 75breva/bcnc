package com.bncn.inditex.service;

import com.bncn.inditex.dto.Price;

import com.bncn.inditex.dto.PricesGet404Response;
import com.bncn.inditex.exception.PriceNotFoundException;
import com.bncn.inditex.model.PriceJpa;

import com.bncn.inditex.repository.PriceRepository;
import com.bncn.inditex.utils.Validate;
import com.google.inject.internal.Errors;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;
    public List<Price> findPrices( Integer productId, Integer brandId, String applicationDate)throws Exception  {
        Validate.validateParammeters(applicationDate);
        List<PriceJpa> priceJpaList = priceRepository.findAllPricesbyDate(productId,brandId, Timestamp.valueOf(applicationDate));

        if(!priceJpaList.isEmpty()){
            return priceJpaList.stream().map(PriceJpa::toPriceDto).toList();
        }
        else{
            throw new PriceNotFoundException("Precio no encontrado para el producto con ID " + productId +
                    " y la cadena con ID " + brandId + " en la fecha " + applicationDate);

        }

    }

}