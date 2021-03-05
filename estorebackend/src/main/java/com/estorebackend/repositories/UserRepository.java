package com.estorebackend.repositories;

import com.estorebackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByEmailAndPassword(String userEmail, String password);
}
