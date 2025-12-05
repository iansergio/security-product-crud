package com.security.dto;

import com.security.domain.product.Product;

public record ProductResponse(Long id, String name, Double price) {
    public ProductResponse(Product product) {
        this(product.getId(), product.getName(), product.getPrice());
    }
}
