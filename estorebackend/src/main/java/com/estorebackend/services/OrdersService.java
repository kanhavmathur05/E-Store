package com.estorebackend.services;

import com.estorebackend.entities.Orders;
import com.estorebackend.vm.OrdersVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrdersService {
    List<OrdersVM> getOrderHistoryListByUserId(int userId);

    List<Orders> saveAllOrders(List<Orders> orderList);
}
