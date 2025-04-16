package com.example.burhanpedia.service;

import com.example.burhanpedia.model.Cart;
import com.example.burhanpedia.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    // Create Cart
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Get Cart by id
    public Cart getCart(String id) {
        return cartRepository.findById(id).orElse(null);  // Return null if not found
    }

    // Update Cart by id
    public Cart updateCart(Cart cart, String id) {
        Cart existingCart = cartRepository.findById(id).orElse(null);

        if (existingCart != null) {
            existingCart.setFull(cart.isFull());
            return cartRepository.save(existingCart);
        } else {
            throw new RuntimeException("Cart not found for id: " + id);
        }
    }

    // Delete Cart by id
    public void deleteCart(String id) {
        cartRepository.deleteById(id);
    }
}
