package com.estorebackend.services.impl;

import com.estorebackend.entities.Cart;
import com.estorebackend.entities.Users;
import com.estorebackend.repositories.UserRepository;
import com.estorebackend.services.UserService;
import com.estorebackend.vm.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users registerNewUser(Users newUser) {
        newUser = userRepository.save(newUser);
        Cart newCart = new Cart();
        newCart.setUserId(newUser.getId());
        return newUser;
    }

    @Override
    public Users updateUserInfo(Users users) {
        users = userRepository.save(users);
        return users;
    }

    @Override
    public Users getUserById(int userId) {
        Optional<Users> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    @Override
    public Users getUserByCredentails(AuthenticationRequest authenticationRequest) {
        String email = Base64.getDecoder().decode(authenticationRequest.getUserEmail()).toString();
        String password = Base64.getDecoder().decode(authenticationRequest.getPassword()).toString();
        Users user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }

    @Override
    public Page<Users> getAllUsers(Pageable pageable) {
        Page<Users> usersList = userRepository.findAll(pageable);
        return usersList;
    }
}
