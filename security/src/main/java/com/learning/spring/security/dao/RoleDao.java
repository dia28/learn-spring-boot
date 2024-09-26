package com.learning.spring.security.dao;

import com.learning.spring.security.entity.Role;

public interface RoleDao {
    Role findRoleByName(String roleName);
}
