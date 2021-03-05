package com.estorebackend.services.impl;

import com.estorebackend.entities.Orders;
import com.estorebackend.repositories.OrdersRepository;
import com.estorebackend.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public Page<Orders> getOrderHistoryListByUserId(int userId, Pageable pageable) {
        return ordersRepository.findAllByUserId(userId, pageable);
    }
}
