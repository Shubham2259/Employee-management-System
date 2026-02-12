package com.securityTutorial.Project.service;

import com.securityTutorial.Project.entity.Employee;
import com.securityTutorial.Project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository repo;
    public EmployeeServiceImpl(EmployeeRepository repo){
        this.repo=repo;
    }
    public List<Employee> getAll() { return repo.findAll(); }

    public Employee save(Employee e) { return repo.save(e); }

    public Employee getById(Long id) { return repo.findById(id).orElseThrow(); }

    public void delete(Long id) { repo.deleteById(id); }

    public List<Employee> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }
}
