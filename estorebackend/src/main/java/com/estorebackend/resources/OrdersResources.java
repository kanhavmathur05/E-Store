package com.estorebackend.resources;

import com.estorebackend.entities.Orders;
import com.estorebackend.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersResources {

    @Autowired
    OrdersService ordersService;

    @GetMapping("/order-history/{userId}")
    public ResponseEntity<Page<Orders>> getUsersOrderHistory(@PathVariable int userId, Pageable pageable) {
        Page<Orders> orderHistory = ordersService.getOrderHistoryListByUserId(userId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(orderHistory);
    }
}
