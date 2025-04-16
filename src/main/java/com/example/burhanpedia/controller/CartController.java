package com.example.burhanpedia.controller;

import com.example.burhanpedia.model.Cart;
import com.example.burhanpedia.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    @Operation(summary = "Create a new cart")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a cart by ID")
    public Cart getCart(@PathVariable String id) {
        return cartService.getCart(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing cart")
    public Cart updateCart(@RequestBody Cart cart, @PathVariable String id) {
        return cartService.updateCart(cart, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a cart by ID")
    public void deleteCart(@PathVariable String id) {
        cartService.deleteCart(id);
    }
}
