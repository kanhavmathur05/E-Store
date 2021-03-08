package com.estorebackend.services.impl;

import com.estorebackend.entities.Product;
import com.estorebackend.repositories.ProductRepository;
import com.estorebackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addNewProduct(Product product) {
        Product addedProduct = productRepository.save(product);
        return addedProduct;
    }

    @Override
    public Product viewProductById(int productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return product.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Page<Product> getProductsBySearch(String query, Pageable pageable) {
        return productRepository.findAllByProductNameLike(query, pageable);
    }
}
