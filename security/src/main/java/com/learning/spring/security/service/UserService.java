package com.learning.spring.security.service;

import com.learning.spring.security.entity.User;
import com.learning.spring.security.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);
    public void save(WebUser webUser);
}
