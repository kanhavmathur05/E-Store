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

import java.util.List;

@Service
public class CartProductsServiceImpl implements CartProductsService {

    @Autowired
    CartProductsRepository cartProductsRepository;

    @Autowired
    CartService cartService;

    @Override
    public List<CartProducts> findAllProductsInUserCart(int userId) {
        Cart userCart = cartService.getCartForUser(userId);
        return cartProductsRepository.findByUserIdAndCartId(userId, userCart.getId());
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
    public void placeOrder(int userId) {
        List<CartProducts> cartProducts = cartProductsRepository.findByUserIdAndCartId(userId,12);

        //
//1        quantityCheck();
//2        deduct quantities from database;
//3        add products to users Order History
//4        place order for user-----generate PDF or bill;
//        for(CartProducts cartProduct:cartProducts)
//        {
//
//        }
    }


}
