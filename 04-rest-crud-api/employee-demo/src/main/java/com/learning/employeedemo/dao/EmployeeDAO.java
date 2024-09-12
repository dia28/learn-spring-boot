package com.learning.employeedemo.dao;

import com.learning.employeedemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee saveEmployee(Employee employee);
    Employee findById(int employeeId);
    void deleteEmployee(int employeeId);
}
