package com.estorebackend.repositories;

import com.estorebackend.entities.CartProducts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductsRepository extends JpaRepository<CartProducts, Integer> {
    Page<CartProducts> findByUserIdAndCartId(int userId, int cartId, Pageable pageable);
}
