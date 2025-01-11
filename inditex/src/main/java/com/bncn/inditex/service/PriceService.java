package com.bncn.inditex.service;

import com.bncn.inditex.dto.Price;

import com.bncn.inditex.exception.PriceNotFoundException;
import com.bncn.inditex.model.PriceJpa;
import com.bncn.inditex.model.ProductJpa;
import com.bncn.inditex.repository.PriceRepository;
import com.bncn.inditex.repository.ProductRepository;
import com.bncn.inditex.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;



@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepository;
    @Autowired
    ProductRepository productRepository;

    /**
     * Funcion que devuelve los precios que concuerdan con el Identificador de producto, brand y que applicationDate este entre startDate y endDate
     * @param productId Id of product
     * @param brandId   Id of brand
     * @param applicationDate  Date to search between start and end date
     * @return Lista de Precios
     * @throws Exception PricesGet400Response or PricesGet404Response
     */
    public List<Price> findPrices( Integer productId, Integer brandId, String applicationDate)throws Exception  {
        Validate.validateParammeters(applicationDate);
        List<PriceJpa> priceJpaList = priceRepository.findAllPricesbyDate(productId,brandId, Timestamp.valueOf(applicationDate));
//        ProductJpa productJpa = new ProductJpa();
//        productJpa.setName("nuevo prod");
//        productJpa.setDescription("buena descripcion");
//        productRepository.save(productJpa);
        if(!priceJpaList.isEmpty()){
            return priceJpaList.stream().map(PriceJpa::toPriceDto).toList();
        }
        else{
            throw new PriceNotFoundException("Precio no encontrado para el producto con ID " + productId +
                    " y la cadena con ID " + brandId + " en la fecha " + applicationDate);
        }

    }

}