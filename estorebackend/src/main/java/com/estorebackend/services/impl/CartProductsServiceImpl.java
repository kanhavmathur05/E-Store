package com.estorebackend.services.impl;

import com.estorebackend.entities.Cart;
import com.estorebackend.entities.CartProducts;
import com.estorebackend.entities.Orders;
import com.estorebackend.entities.Product;
import com.estorebackend.repositories.CartProductsRepository;
import com.estorebackend.services.CartProductsService;
import com.estorebackend.services.CartService;
import com.estorebackend.services.OrdersService;
import com.estorebackend.services.ProductService;
import com.estorebackend.vm.CartProductsToShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartProductsServiceImpl implements CartProductsService {

    @Autowired
    CartProductsRepository cartProductsRepository;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    OrdersService ordersService;

    @Override
    public List<CartProductsToShow> findAllProductsInUserCart(int userId) {
        Cart userCart = cartService.getCartForUser(userId);
        List<CartProducts> cartProductsList = cartProductsRepository.findByUserIdAndCartId(userId, userCart.getId());
        List<CartProductsToShow> listOfProductsInUserCart = new ArrayList<>();
        cartProductsList.forEach(cartProduct -> {
            CartProductsToShow cartProductsToShow = new CartProductsToShow();
            Product product = productService.viewProductById(cartProduct.getProductId());
            cartProductsToShow.setId(cartProduct.getId());
            cartProductsToShow.setPrice(product.getPrice());
            cartProductsToShow.setProductImage(product.getProductImage());
            cartProductsToShow.setProductName(product.getProductName());
            listOfProductsInUserCart.add(cartProductsToShow);
        });

        return listOfProductsInUserCart;
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
        List<CartProducts> cartProducts = cartProductsRepository.findByUserIdAndCartId(userId, 12);
        List<Orders> listOfOrders = new ArrayList<>();
        cartProducts.forEach(cartProduct -> {
            Orders order = new Orders();
            order.setUserId(cartProduct.getUserId());
            order.setProductId(cartProduct.getProductId());
            order.setQuantity(cartProduct.getQuantity());
            order.setTotal(cartProduct.getTotal());
            order.setBoughtOn(LocalDate.now());
            listOfOrders.add(order);
        });
        ordersService.saveAllOrders(listOfOrders);
    }
}
