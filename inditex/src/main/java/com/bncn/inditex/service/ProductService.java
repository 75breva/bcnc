package com.bncn.inditex.service;

import com.bncn.inditex.dto.Product;
import com.bncn.inditex.model.ProductJpa;
import com.bncn.inditex.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired()
    ProductRepository productRepository;
    public List<Product> findAll() {
        // Lógica para obtener productos de la base de datos
        //List<ProductJpa> productJpaList = new ArrayList<>();
        List<ProductJpa> productJpaList = productRepository.findAll();
        return productJpaList.stream().map(ProductJpa::toProduct).toList();
    }

//    public Product findById(String id) {
//        // Obtener un producto por ID
//        Optional<ProductJpa> productJpaOptional = productRepository.findById(Integer.valueOf(id));
//        if (productJpaOptional != null) {
//            return productJpaOptional.get().toProduct();
//        } else {
//            // Manejar el caso en que el producto no se encuentre
//            return new Product(); // O lanzar una excepción, según tu lógica
//        }
//    }
    public Product findById(String id) {
        //Product product = new Product();
        Optional<ProductJpa> productJpaOptional = productRepository.findById(Integer.valueOf(id));
        return productJpaOptional.map(ProductJpa::toProduct).orElse(new Product());
        //return product;
    }

}