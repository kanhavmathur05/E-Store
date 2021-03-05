package com.estorebackend.repositories;

import com.estorebackend.entities.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Page<Address> findAllByUserId(int userId, Pageable pageable);
}
