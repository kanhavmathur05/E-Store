package com.estorebackend.services;

import com.estorebackend.entities.Cart;

public interface CartService {
    Cart getCartForUser(int userId);
    Cart createCartForNewUser(Cart newCart);
}
