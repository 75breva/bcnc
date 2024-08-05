package com.bncn.inditex.repository;


import com.bncn.inditex.model.PriceJpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface PriceRepository extends BaseRepository<PriceJpa, Integer> {
    /**
     * Consulta que devuelve los precios que coincida el codigo del producto, la cadena del grupo (cod_brand) y la fecha este
     * entre star_date y end_date
     * @param codProduct
     * @param codBrand
     * @param date
     * @return Devuelve lista de precios
     */
    @Query(value= "SELECT * " +
            "FROM prices p " +
            "WHERE p.cod_product = ? AND p.cod_brand = ? AND ? BETWEEN p.start_date  AND p.end_date  ", nativeQuery = true)
    List<PriceJpa> findAllPricesbyDate(Integer codProduct, Integer codBrand, Timestamp date);

}
