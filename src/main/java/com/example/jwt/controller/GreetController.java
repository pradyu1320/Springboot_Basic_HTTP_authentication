package com.example.jwt.controller;

import com.example.jwt.entity.AuthenticatedUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class GreetController {
    @GetMapping
    public String greet(){
        //get user from security context holder
        AuthenticatedUser user = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "HI "+user.getUsername()+  "you are allowed !!!";
    }
}
