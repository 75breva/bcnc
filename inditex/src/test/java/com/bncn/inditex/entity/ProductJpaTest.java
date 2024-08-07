package com.bncn.inditex.entity;

import com.bncn.inditex.model.PriceJpa;
import com.bncn.inditex.model.ProductJpa;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ProductJpaTest {
    ProductJpa productJpa = new ProductJpa();

    @Test
    void testToProductJpa(){
        productJpa.setDescription("description");
        productJpa.setId(10);
        productJpa.setName("name");
        productJpa.setPriceJpaList(new ArrayList<>());

        Assert.assertNotNull(productJpa.getDescription());
        Assert.assertNotNull(productJpa.getName());
        Assert.assertNotNull(productJpa.getId());
        Assert.assertNotNull(productJpa.getPriceJpaList());
    }
}
