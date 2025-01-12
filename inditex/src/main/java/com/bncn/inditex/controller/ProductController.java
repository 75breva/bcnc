package com.bncn.inditex.controller;

import com.bncn.inditex.avro.Customer;
import com.bncn.inditex.dto.Price;
import com.bncn.inditex.service.PriceService;
import com.bncn.inditex.service.ProducerKafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/prices")
public class ProductController {

    @Autowired
    private PriceService priceService;
    @Autowired
    private ProducerKafkaService producerKafkaService;

    @GetMapping
    public List<Price> getPrices(
            @RequestParam("applicationDate") String applicationDateStr,
            @RequestParam("productId") Integer productId,
            @RequestParam("brandId") Integer brandId) throws Exception {
        return priceService.findPrices(productId, brandId, applicationDateStr);
    }
    @PostMapping("/publish")
    public String sendMessage(@RequestBody Customer customer) {
        producerKafkaService.save(customer);
        return "Mensaje enviado a Kafka!";
    }
}
