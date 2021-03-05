package com.estorebackend.services;

import com.estorebackend.entities.CartProducts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CartProductsService {
    Page<CartProducts> findAllProductsInUserCart(int userId, Pageable pageable);

    CartProducts addProductToCart(CartProducts cartProducts);

    void removeProductFromCart(int cartProductId);

    void checkOut(int userId);
}
