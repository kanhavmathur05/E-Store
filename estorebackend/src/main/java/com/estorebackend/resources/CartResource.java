package com.estorebackend.resources;

import com.estorebackend.entities.CartProducts;
import com.estorebackend.services.CartProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartResource {

    @Autowired
    CartProductsService cartProductsService;

    @PostMapping("/add-product")
    public ResponseEntity<CartProducts> addProductToCart(@RequestBody CartProducts cartProducts) {
        CartProducts addedCartProduct = cartProductsService.addProductToCart(cartProducts);
        return ResponseEntity.status(HttpStatus.OK).body(addedCartProduct);
    }

    @PostMapping("/update-product-in-cart")
    public ResponseEntity<CartProducts> updateProductInCart(@RequestBody CartProducts cartProducts) {
        CartProducts updatedCartProduct = cartProductsService.addProductToCart(cartProducts);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCartProduct);
    }

    @DeleteMapping("/delete-product-from-cart/{cartProductId}")
    public ResponseEntity<Void> deleteProductFromCart(@PathVariable int cartProductId) {
        cartProductsService.removeProductFromCart(cartProductId);
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    @GetMapping("products-in-user-cart/{userId}")
    public ResponseEntity<Page<CartProducts>> getProductsInUserCart(@PathVariable int userId, Pageable pageable) {
        Page<CartProducts> productsInUserCart = cartProductsService.findAllProductsInUserCart(userId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(productsInUserCart);
    }
}
