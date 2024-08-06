package com.bncn.inditex.entity;

import com.bncn.inditex.model.BrandJpa;
import com.bncn.inditex.model.PriceJpa;
import com.bncn.inditex.model.ProductJpa;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

public class PriceJpaTest {
    PriceJpa priceJpa = new PriceJpa();

    @Test void  testToPriceJpa(){
        priceJpa.setPriceList(1);
        priceJpa.setPriceFinal("priceFinal");
        priceJpa.setId(20);
        priceJpa.setMoneda("EUR");
        priceJpa.setEndDate(new Timestamp(System.currentTimeMillis()));
        priceJpa.setStartDate(new Timestamp(System.currentTimeMillis()));
        priceJpa.setProductJpa(new ProductJpa());
        priceJpa.setBrandJpa(new BrandJpa());
        priceJpa.setPriority(1);
        priceJpa.setPriceList(2);
        Assert.assertNotNull(priceJpa.getId());
        Assert.assertNotNull(priceJpa.getPriceFinal());
        Assert.assertNotNull(priceJpa.getId());
        Assert.assertNotNull(priceJpa.getMoneda());
        Assert.assertNotNull(priceJpa.getEndDate());
        Assert.assertNotNull(priceJpa.getStartDate());
        Assert.assertNotNull(priceJpa.getProductJpa());
        Assert.assertNotNull(priceJpa.getBrandJpa());
        Assert.assertNotNull(priceJpa.getPriceList());
        Assert.assertNotNull(priceJpa.getPriority());

    }
}
