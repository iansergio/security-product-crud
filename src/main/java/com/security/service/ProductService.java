package com.security.service;

import com.security.dto.ProductRequest;
import com.security.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse save(ProductRequest body);
    List<ProductResponse> getAll();
}
