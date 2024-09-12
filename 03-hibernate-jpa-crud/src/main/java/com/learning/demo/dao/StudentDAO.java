package com.learning.demo.dao;

import com.learning.demo.entity.Student;

import java.util.List;

public interface StudentDAO { // Data Access Object

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
