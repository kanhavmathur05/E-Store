package com.estorebackend.resources;

import com.estorebackend.entities.Users;
import com.estorebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class AdminResource {

    @Autowired
    UserService userService;

    @GetMapping("/get-all-users")
    public ResponseEntity<List<Users>> getAllUsers()
    {
        List<Users> usersList =  userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }
}
