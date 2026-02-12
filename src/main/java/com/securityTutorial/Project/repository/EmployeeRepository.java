package com.securityTutorial.Project.repository;

import com.securityTutorial.Project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
}
