package com.bncn.inditex;

//import com.bncn.inditex.controller.ProductController;
import com.bncn.inditex.controller.ProductController;
import com.bncn.inditex.exception.PriceNotFoundException;
import com.bncn.inditex.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySources;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureTestDatabase
class InditexApplicationTests {

    @Autowired
    ProductController productController;
    @Autowired
    PriceService priceService;
	@Test
	void testListProducts() {
        try {
            productController.getPrices("2024-08-11 15:00:00",35455,1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testListProductsNotFound() {
        try {
            productController.getPrices("2024-08-11 15:00:00",35456,1);
        } catch (Exception e) {
            assertThrows(PriceNotFoundException.class, () -> {
                priceService.findPrices(35456, 1, "2024-08-11 15:00:00");
            });
        }
    }

    @Test
    void testListProductsInvalidParameters() {
        try {
            productController.getPrices("",35456,1);
        } catch (Exception e) {
            assertThrows(PriceNotFoundException.class, () -> {
                priceService.findPrices(35456, 1, "");
            });
        }
    }



}
