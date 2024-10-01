package com.learning.advanced.jpa.dao;

import com.learning.advanced.jpa.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void delete(int id);

}
