package com.bncn.inditex.model;

import com.bncn.inditex.utils.format;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Entity
@Table(name = "brand")
@Data
@Slf4j
public class BrandJpa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_brand", nullable = false)
    private Integer id;

    @Column(name = "des_name",length = format.LENGTH_NAME)
    private String name;

    @Column(name = "des_description",length = format.LENGTH_DESCRIPTION)
    private String description;
}
