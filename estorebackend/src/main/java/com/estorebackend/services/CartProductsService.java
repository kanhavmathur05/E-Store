package com.estorebackend.services;

import com.estorebackend.entities.CartProducts;
import com.estorebackend.vm.CartProductsToShow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CartProductsService {
    List<CartProductsToShow> findAllProductsInUserCart(int userId);

    CartProducts addProductToCart(CartProducts cartProducts);

    void removeProductFromCart(int cartProductId);

    void placeOrder(int userId);
}
