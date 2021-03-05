package com.estorebackend.resources;

import com.estorebackend.entities.Users;
import com.estorebackend.services.UserService;
import com.estorebackend.vm.AuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
        Users newUser = userService.registerNewUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Users> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        Users users = userService.getUserByCredentails(authenticationRequest);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/activate-deactivate-user/{userId}")
    public ResponseEntity<Users> activateDeactivateUser(@PathVariable int userId) {
        Users user = userService.getUserById(userId);
        user.setActivate(!user.isActivate());
        user = userService.updateUserInfo(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
