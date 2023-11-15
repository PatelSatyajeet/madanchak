package com.madanchak.user_service.controller;

import com.madanchak.user_service.model.User;
import com.madanchak.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping
    public ResponseEntity <List<User>> findAllUsersById(){
        List<User> allUser=userService.getAllUsers();
        return ResponseEntity.ok(allUser);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable String userId){
        User user=userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

}
