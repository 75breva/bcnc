package com.bncn.inditex.model;





import com.bncn.inditex.utils.format;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Entity
@Table(name = "product")
//@SequenceGenerator(sequenceName = "qidtxusr0", allocationSize = 1, name = "qidtxusr0")
//@SequenceGenerator(sequenceName = "qusers0", allocationSize = 1, name = "qusers0")
@Data
@Slf4j  // Importante para que no me de problemas encontrando las entidades
public class ProductJpa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cod_product", nullable = false)
    private Integer id;

    @Column(name = "des_name",length = format.LENGTH_NAME)
    private String name;

    @Column(name = "des_description", length = format.LENGTH_DESCRIPTION)
    private String description;


}