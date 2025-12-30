package com.eps.service;

import com.eps.model.Employee;
import com.eps.dao.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {

        this.repo = repo;
    }

    public Employee addEmployee(String name, String desig, double salary, String phone, String email) {
        Employee e = new Employee(0, name, desig, salary, phone, email);
        return repo.add(e);
    }

    public boolean updateEmployee(Employee e) {

        return repo.update(e);
    }

    public boolean deleteEmployee(int id) {

        return repo.delete(id);
    }

    public List<Employee> getAllEmployees() {

        return repo.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {

        return repo.findById(id);
    }
}
