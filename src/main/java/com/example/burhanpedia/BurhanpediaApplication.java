package com.example.burhanpedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.burhanpedia.model")  // Ensure this points to the package containing Penjual
public class BurhanpediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurhanpediaApplication.class, args);
	}
}
