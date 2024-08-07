package com.bncn.inditex.entity;

import com.bncn.inditex.model.BrandJpa;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BrandJpaTest {

    BrandJpa brandJpa = new BrandJpa();

    @Test
    public void testToBrandJpa(){
        brandJpa.setId(10);
        brandJpa.setName("name");
        brandJpa.setDescription("description");
        brandJpa.setPriceJpaList(new ArrayList<>());
        Assert.assertNotNull(brandJpa.getId());
        Assert.assertNotNull(brandJpa.getName());
        Assert.assertNotNull(brandJpa.getDescription());
        Assert.assertNotNull(brandJpa.getPriceJpaList());
    }
}
