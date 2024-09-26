package com.learning.spring.security.dao;

import com.learning.spring.security.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName(String userName) {
        TypedQuery<User> query = entityManager.createQuery("from User where userName=:uName and enabled=true", User.class);
        query.setParameter("uName", userName);

        User user;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            user = null;
        }

        return user;
    }
}
