package com.example.burhanpedia.service;

import com.example.burhanpedia.model.Penjual;
import com.example.burhanpedia.model.Product;
import com.example.burhanpedia.repository.PenjualRepository;
import com.example.burhanpedia.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final PenjualRepository penjualRepository;

    // Create a new product and link it to a penjual
    public Product createProduct(String penjualId, Product product) {
        Penjual penjual = penjualRepository.findById(penjualId)
                .orElseThrow(() -> new RuntimeException("Penjual not found: " + penjualId));

        // Link the product to the penjual
        product.setPenjual(penjual);

        return productRepository.save(product);
    }

    // Get product by its ID
    public Product getProduct(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    // Update product by its ID
    @Transactional
    public Product updateProduct(String productId, Product updatedProduct) {
        // Fetch the existing product
        Product existingProduct = productRepository.findById(productId).orElse(null);

        // (Optional) Check if we need to update the penjual
        if (existingProduct != null) {
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setStok(updatedProduct.getStok());
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found for id: " + productId);
        }
    }


    // Delete product by its ID
    @Transactional
    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

}
