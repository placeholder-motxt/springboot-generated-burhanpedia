package com.example.burhanpedia.repository;

import com.example.burhanpedia.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    // You can add custom query methods for Cart if needed
}
