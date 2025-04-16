package com.example.burhanpedia.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {

    @Id
    @Column(updatable = false, nullable = false)
    private String id = UUID.randomUUID().toString();  // Auto-generate a UUID for each product

    private String productName;
    private int stok;
    private int price;

    @ManyToOne
    @JoinColumn(name = "penjual_id")
    private Penjual penjual;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();  // Many-to-many relationship with Cart using ArrayList

}
