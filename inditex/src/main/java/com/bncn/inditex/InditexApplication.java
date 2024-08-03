package com.bncn.inditex;

import com.bncn.inditex.model.ProductJpa;
import com.bncn.inditex.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.bncn.inditex.model")
@EnableJpaRepositories(basePackages = "com.bncn.inditex.repository")
public class InditexApplication {
	public static void main(String[] args) {
		SpringApplication.run(InditexApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(ProductRepository productRepository) {
		return args -> {
			// Puedes añadir pruebas aquí para verificar que el repositorio se inyecta correctamente
			System.out.println("ProductRepository is injected: " + (productRepository != null));
//			ProductJpa productJpa = new ProductJpa();
//			productJpa.setSurname("Arredondo");
//			productJpa.setName("bREVA");
//			productJpa.setId(1);
//			productRepository.save(productJpa);
		};
	}
}