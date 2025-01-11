package com.bncn.inditex.model;

import com.bncn.inditex.utils.format;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "brand",schema = "bcnc")
@Data
@Slf4j
@SequenceGenerator(sequenceName = "bcnc.QBCNCBRA0", allocationSize = 1, name = "QBCNCBRA0")
public class BrandJpa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QBCNCBRA0")
    @Column(name = "cod_brand", nullable = false)
    private Integer id;

    @Column(name = "des_name",length = format.LENGTH_NAME)
    private String name;

    @Column(name = "des_description",length = format.LENGTH_DESCRIPTION)
    private String description;

    @OneToMany(mappedBy = "brandJpa", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PriceJpa> priceJpaList;

}
