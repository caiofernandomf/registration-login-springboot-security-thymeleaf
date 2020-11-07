package net.javaguides.springboot.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.springsecurity.controller.dto.UserRegistrationDto;
import net.javaguides.springboot.springsecurity.model.User;

public interface UserService extends UserDetailsService{
    
    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}