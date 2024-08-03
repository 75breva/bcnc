package com.bncn.inditex.repository;

import com.bncn.inditex.model.ProductJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductJpa, Integer> {
    Optional<ProductJpa> findById(Integer id);
}