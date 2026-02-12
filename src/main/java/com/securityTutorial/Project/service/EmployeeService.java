package com.securityTutorial.Project.service;

import com.securityTutorial.Project.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee save(Employee e);
    Employee getById(Long id);
    void delete(Long id);
    List<Employee> searchByName(String name);
}
