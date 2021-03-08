package com.estorebackend.services;

import com.estorebackend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product addNewProduct(Product product);

    Product viewProductById(int productId);

    List<Product> getAllProducts();

    void deleteProduct(int productId);

    Page<Product> getProductsBySearch(String query, Pageable pageable);
}
