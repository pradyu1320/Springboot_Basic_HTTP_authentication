package com.example.jwt.controller;

import com.example.jwt.entity.User;
import com.example.jwt.entity.UserDTO;
import com.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService serv;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO dto){
        serv.register(dto);
        return ResponseEntity.ok("user created successfully !!!");
    }
}
