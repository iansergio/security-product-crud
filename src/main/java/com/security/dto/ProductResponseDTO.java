package com.security.dto;

import com.security.domain.product.Product;

public record ProductResponseDTO(Long id, String name, Double price) {
    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice());
    }
}
