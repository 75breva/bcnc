package com.bncn.inditex;

import com.bncn.inditex.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InditexApplicationTests {
//
    @Autowired
    ProductController productController;
	@Test
	void testListProducts() {
        productController.listProducts();
	}

}
