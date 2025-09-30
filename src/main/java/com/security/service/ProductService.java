package com.security.service;

import com.security.domain.product.Product;
import com.security.dto.ProductRequestDTO;
import com.security.dto.ProductResponseDTO;
import com.security.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO save(ProductRequestDTO body) {
        Product product = productRepository.save(new Product(body));

        return new ProductResponseDTO(product);
    }

    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponseDTO::new)
                .toList();
    }
}
