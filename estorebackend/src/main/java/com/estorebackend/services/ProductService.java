package com.estorebackend.services;

import com.estorebackend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product addNewProduct(Product product);

    Product viewProductById(int productId);

    Page<Product> getAllProducts(Pageable pageable);

    void deleteProduct(int productId);

    Page<Product> getProductsBySearch(String query, Pageable pageable);
}
