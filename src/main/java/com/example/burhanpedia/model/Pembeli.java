package com.example.burhanpedia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pembeli extends User {

    private int balance;  // Balance of the Pembeli

    @OneToOne
    @JoinColumn(name = "cart_id", nullable = true)  // nullable attribute should be in @JoinColumn
    private Cart cart;  // One to One relationship with Cart (nullable)

    // Method to top up balance
    public void topUp(int balance) {}
}
