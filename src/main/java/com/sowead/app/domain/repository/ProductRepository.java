package com.sowead.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sowead.app.domain.Product;

public interface ProductRepository {
    List<Product> getAll();
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
