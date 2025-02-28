package com.diabetesmanagementsystem.Diabetes.Management.System.controllers;

import com.diabetesmanagementsystem.Diabetes.Management.System.model.User;
import com.diabetesmanagementsystem.Diabetes.Management.System.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to create a new user (signup)
    @PostMapping("/signup")
    public ResponseEntity<Long> signUp(@Valid @RequestBody User user) {
        try {
            Long createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // If passwords don't match
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> getString() {
        try {
            return new ResponseEntity<>("Hello", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // If passwords don't match
        }
    }

}

