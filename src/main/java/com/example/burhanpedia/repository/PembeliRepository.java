package com.example.burhanpedia.repository;

import com.example.burhanpedia.model.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PembeliRepository extends JpaRepository<Pembeli, String> {
    // Custom query methods can be added if needed
}
