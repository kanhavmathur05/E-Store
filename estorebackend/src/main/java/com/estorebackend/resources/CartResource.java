package com.estorebackend.resources;

import com.estorebackend.entities.Cart;
import com.estorebackend.entities.CartProducts;
import com.estorebackend.services.CartProductsService;
import com.estorebackend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartResource {

    @Autowired
    CartProductsService cartProductsService;

    @Autowired
    CartService cartService;

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
    public ResponseEntity<List<CartProducts>> getProductsInUserCart(@PathVariable int userId) {
        List<CartProducts> productsInUserCart = cartProductsService.findAllProductsInUserCart(userId);
        return ResponseEntity.status(HttpStatus.OK).body(productsInUserCart);
    }

    @GetMapping("/get-cart/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable int userId)
    {
        Cart cart = cartService.getCartForUser(userId);
        ResponseEntity.status(HttpStatus.OK).body(cart);
    }
}
