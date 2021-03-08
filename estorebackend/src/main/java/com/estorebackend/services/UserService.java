package com.estorebackend.services;

import com.estorebackend.entities.Users;
import com.estorebackend.vm.AuthenticationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Users registerNewUser(Users users);

    Users updateUserInfo(Users users);

    Users getUserById(int userId);

    Users getUserByCredentails(AuthenticationRequest authenticationRequest);

    List<Users> getAllUsers();
}
