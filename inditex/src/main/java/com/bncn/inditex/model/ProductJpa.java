package com.bncn.inditex.model;




import com.bncn.inditex.dto.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@Table(name = "users")
//@SequenceGenerator(sequenceName = "qidtxusr0", allocationSize = 1, name = "qidtxusr0")
//@SequenceGenerator(sequenceName = "qusers0", allocationSize = 1, name = "qusers0")
@Data
@Slf4j  // Importante para que no me de problemas encontrando las entidades
public class ProductJpa {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "qusers0")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cod_usr")
    private Integer id;

    @Column(name = "des_name_usr")
    @NotNull
    @Size(min = 1, max = 10)
    private String name;

    @Column(name = "des_surname_usr")
    @NotNull
    @Size(max = 20)
    private String surname;

    public Product toProduct(){
        Product product = new Product();
        product.setSurname(this.surname);
        product.setName(this.name);
        product.setId(this.id.toString());
        return product;
    }

}