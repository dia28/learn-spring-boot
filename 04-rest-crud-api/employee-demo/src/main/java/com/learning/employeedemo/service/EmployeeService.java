package com.learning.employeedemo.service;

import com.learning.employeedemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee saveEmployee(Employee employee);

    void deleteEmployee(int employeeId);
}
