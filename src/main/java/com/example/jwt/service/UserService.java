package com.example.jwt.service;

import com.example.jwt.entity.AuthenticatedUser;
import com.example.jwt.entity.User;
import com.example.jwt.entity.UserDTO;
import com.example.jwt.reposito.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder encoder;

    public User register(UserDTO dto){
        System.out.println("Request Body " +dto);
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        return repo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        return new AuthenticatedUser(user);
    }
}
