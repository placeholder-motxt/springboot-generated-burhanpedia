package com.example.burhanpedia.repository;

import com.example.burhanpedia.model.Penjual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenjualRepository extends JpaRepository<Penjual, String> {
    // You can add custom query methods for Penjual if needed
}
