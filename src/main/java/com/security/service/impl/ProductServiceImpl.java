package com.security.service.impl;

import com.security.domain.product.Product;
import com.security.dto.ProductRequest;
import com.security.dto.ProductResponse;
import com.security.repository.ProductRepository;
import com.security.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse save(ProductRequest body) {
        Product product = productRepository.save(new Product(body));

        return new ProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponse::new)
                .toList();
    }

}
