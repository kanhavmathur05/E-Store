package com.estorebackend.services;

import com.estorebackend.entities.Cart;

public interface CartService {
    Cart getCartForUser(int userId);
}
