package com.learning.spring.security.dao;

import com.learning.spring.security.entity.User;

public interface UserDao {
    User findByUserName(String userName);
}
