package com.estorebackend.repositories;

import com.estorebackend.entities.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    Page<Orders> findAllByUserId(int UserId, Pageable pageable);
}
