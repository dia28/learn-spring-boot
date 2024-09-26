package com.learning.spring.security.service;

import com.learning.spring.security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);
}
