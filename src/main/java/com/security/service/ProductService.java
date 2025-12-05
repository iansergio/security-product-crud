package com.security.service;

import com.security.domain.product.Product;
import com.security.dto.ProductRequest;
import com.security.dto.ProductResponse;
import com.security.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse save(ProductRequest body) {
        Product product = productRepository.save(new Product(body));

        return new ProductResponse(product);
    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponse::new)
                .toList();
    }
}
