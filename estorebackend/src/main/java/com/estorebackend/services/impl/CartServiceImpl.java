package com.estorebackend.services.impl;

import com.estorebackend.entities.Cart;
import com.estorebackend.repositories.CartRepository;
import com.estorebackend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart getCartForUser(int userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public Cart createCartForNewUser(Cart newCart) {
        return cartRepository.save(newCart);

    }
}
