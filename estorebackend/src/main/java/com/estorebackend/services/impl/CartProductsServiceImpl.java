package com.estorebackend.services.impl;

import com.estorebackend.entities.Cart;
import com.estorebackend.entities.CartProducts;
import com.estorebackend.repositories.CartProductsRepository;
import com.estorebackend.services.CartProductsService;
import com.estorebackend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartProductsServiceImpl implements CartProductsService {

    @Autowired
    CartProductsRepository cartProductsRepository;

    @Autowired
    CartService cartService;

    @Override
    public Page<CartProducts> findAllProductsInUserCart(int userId, Pageable pageable) {
        Cart userCart = cartService.getCartForUser(userId);
        return cartProductsRepository.findByUserIdAndCartId(userId, userCart.getId(), pageable);
    }

    @Override
    public CartProducts addProductToCart(CartProducts cartProducts) {
        CartProducts addedCartProduct = cartProductsRepository.save(cartProducts);
        return addedCartProduct;
    }

    @Override
    public void removeProductFromCart(int cartProductId) {
        cartProductsRepository.deleteById(cartProductId);
    }

    @Override
    public void checkOut(int userId) {

    }
}
