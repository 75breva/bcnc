package com.bncn.inditex.entity;

import com.bncn.inditex.model.ProductJpa;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ProductJpaTest {
    ProductJpa productJpa = new ProductJpa();

    @Test
    void testToProductJpa(){
        productJpa.setDescription("description");
        productJpa.setId(10);
        productJpa.setName("name");

        Assert.assertNotNull(productJpa.getDescription());
        Assert.assertNotNull(productJpa.getName());
        Assert.assertNotNull(productJpa.getId());
    }
}
