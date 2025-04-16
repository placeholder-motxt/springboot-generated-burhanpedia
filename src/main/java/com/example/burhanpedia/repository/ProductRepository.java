package com.example.burhanpedia.repository;

import com.example.burhanpedia.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // Additional query methods can be defined here if needed
}
