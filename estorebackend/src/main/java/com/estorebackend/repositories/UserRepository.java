package com.estorebackend.repositories;

import com.estorebackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Override
    List<Users> findAll();

    Users findByEmailAndPassword(String userEmail, String password);
}
