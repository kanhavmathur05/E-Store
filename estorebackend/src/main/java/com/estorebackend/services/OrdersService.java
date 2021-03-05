package com.estorebackend.services;

import com.estorebackend.entities.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrdersService {
    Page<Orders> getOrderHistoryListByUserId(int userId, Pageable pageable);
}
