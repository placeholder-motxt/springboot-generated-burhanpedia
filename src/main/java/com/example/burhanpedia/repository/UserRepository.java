package com.example.burhanpedia.repository;

import com.example.burhanpedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Custom query to find user by id (this is automatically supported by JpaRepository)
}
