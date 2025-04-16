package com.example.burhanpedia.controller;

import com.example.burhanpedia.model.Product;
import com.example.burhanpedia.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @Operation(summary = "Create a new product for a given penjual")
    public Product createProduct(
            @RequestParam String penjualId,
            @RequestBody Product product
    ) {
        return productService.createProduct(penjualId, product);
    }

    @GetMapping("/{productId}")
    @Operation(summary = "Get a product by ID")
    public Product getProduct(@PathVariable String productId) {
        return productService.getProduct(productId);
    }

    @PutMapping("/{productId}")
    @Operation(summary = "Update an existing product")
    public Product updateProduct(
            @PathVariable String productId,
            @RequestBody Product updatedProduct
    ) {
        return productService.updateProduct(productId, updatedProduct);
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "Delete a product by ID")
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
    }

}
