package com.estorebackend.resources;

import com.estorebackend.entities.Orders;
import com.estorebackend.services.CartProductsService;
import com.estorebackend.services.CartService;
import com.estorebackend.services.OrdersService;
import com.estorebackend.vm.OrdersVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class OrdersResources {

    @Autowired
    OrdersService ordersService;

    @Autowired
    CartProductsService cartProductsService;

    @GetMapping("/order-history/{userId}")
    public ResponseEntity<List<OrdersVM>> getUsersOrderHistory(@PathVariable int userId) {
        List<OrdersVM> orderHistory = ordersService.getOrderHistoryListByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(orderHistory);
    }

    @GetMapping("/place-order/{userId}")
    public ResponseEntity<Void> placeOrder(@PathVariable int userId)
    {
        cartProductsService.placeOrder(userId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
