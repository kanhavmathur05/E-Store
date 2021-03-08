package com.estorebackend.services.impl;

import com.estorebackend.entities.Orders;
import com.estorebackend.entities.Product;
import com.estorebackend.repositories.OrdersRepository;
import com.estorebackend.services.OrdersService;
import com.estorebackend.services.ProductService;
import com.estorebackend.vm.OrdersVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductService productService;

    @Override
    public List<OrdersVM> getOrderHistoryListByUserId(int userId) {
        List<Orders> listOrders = ordersRepository.findAllByUserId(userId);
        List<OrdersVM> orderHistory=new ArrayList<>();
        listOrders.forEach(listOrder->{
            OrdersVM orderVM=new OrdersVM();
            Product product=productService.viewProductById(listOrder.getProductId());
            orderVM.setId(listOrder.getId());
            orderVM.setProductId(listOrder.getProductId());
            orderVM.setProductImage(product.getProductImage());
            orderVM.setQuantity(product.getAvailableQuantity());
            orderVM.setTotal(product.getPrice());
            orderVM.setProductName(product.getProductName());
            orderVM.setDescription(product.getDescription());
            orderHistory.add(orderVM);
        });
        return orderHistory;
    }

    @Override
    public List<Orders> saveAllOrders(List<Orders> orderList) {
        return ordersRepository.saveAll(orderList);
    }
}
