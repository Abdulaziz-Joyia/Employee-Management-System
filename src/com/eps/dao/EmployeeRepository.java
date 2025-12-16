package com.eps.dao;

import com.eps.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee add(Employee e);
    boolean update(Employee e);
    boolean delete(int id);
    Optional<Employee> findById(int id);
    List<Employee> findAll();
}
