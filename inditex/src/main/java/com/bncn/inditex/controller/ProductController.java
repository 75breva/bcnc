package com.bncn.inditex.controller;

import com.bncn.inditex.dto.Price;

import com.bncn.inditex.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/prices")
public class ProductController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public List<Price> getPrices(
            @RequestParam("applicationDate") String applicationDateStr,
            @RequestParam("productId") Integer productId,
            @RequestParam("brandId") Integer brandId) {

        return priceService.findPrices(productId, brandId, applicationDateStr);
    }
}
