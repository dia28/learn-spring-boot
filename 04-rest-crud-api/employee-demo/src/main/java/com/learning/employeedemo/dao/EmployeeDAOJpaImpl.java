package com.learning.employeedemo.dao;

import com.learning.employeedemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    // define entity manager
    EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        return theQuery.getResultList();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee); // execute update or insert
        return dbEmployee;
    }

    @Override
    public Employee findById(int employeeId) {
        Employee theEmployee = entityManager.find(Employee.class, employeeId);
        return theEmployee;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee theEmployee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(theEmployee);
    }
}
