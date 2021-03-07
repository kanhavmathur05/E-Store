package com.estorebackend.services;

import com.estorebackend.entities.CartProducts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CartProductsService {
    List<CartProducts> findAllProductsInUserCart(int userId);

    CartProducts addProductToCart(CartProducts cartProducts);

    void removeProductFromCart(int cartProductId);

    void placeOrder(int userId);
}
