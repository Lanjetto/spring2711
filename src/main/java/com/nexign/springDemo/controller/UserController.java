package com.nexign.springDemo.controller;

import com.nexign.springDemo.entities.UserEntity;
import com.nexign.springDemo.model.User;
import com.nexign.springDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping
    public ResponseEntity<UserEntity> addUser(@RequestBody User user) {
        UserEntity createdUser = userService.addUser(user);
        return ResponseEntity.ok(createdUser);
    }

}
