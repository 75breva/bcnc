package com.bncn.inditex.model;


import com.bncn.inditex.dto.Price;
import com.bncn.inditex.utils.format;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "prices")
@Data
@Slf4j
public class PriceJpa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_price", nullable = false)
    private Integer id;
    @ManyToOne(targetEntity = ProductJpa.class)
    @JoinColumn(name = "cod_product", nullable = false)
    private ProductJpa productJpa;
    @ManyToOne(targetEntity = BrandJpa.class)
    @JoinColumn(name = "cod_brand", nullable = false)
    private BrandJpa brandJpa;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "price_final", length  = format.LENGTH_NAME)
    private String priceFinal;

    @Column(name = "moneda", nullable = false, length = format.LENGTH_CODE)
    private String moneda;

    /**
     * Funcion para parsear el objeto bbdd-jpa al DTO
     * @return objeto DTO Price
     */
    // Funcion para parsear el objeto bbdd-jpa al DTO
    public Price toPriceDto(){
        Price priceDto = new Price();
        // Al poner todos los objetos not null, no compruebo si esta vacios.
        priceDto.setBrandId(this.brandJpa.getId());
        priceDto.setTarifApli(this.priority);
        priceDto.setFinalPrice(Float.valueOf(this.priceFinal));
        return priceDto;

    }

}
