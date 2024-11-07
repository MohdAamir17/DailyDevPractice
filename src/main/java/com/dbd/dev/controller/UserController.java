package com.dbd.dev.controller;

import com.dbd.dev.entity.User;
import com.dbd.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping
    public ResponseEntity<Object> getAllUserDetails() {
       List<User> allUserList =   userService.getAllUserDetails();
       return ResponseEntity.ok(allUserList);
    }
}
