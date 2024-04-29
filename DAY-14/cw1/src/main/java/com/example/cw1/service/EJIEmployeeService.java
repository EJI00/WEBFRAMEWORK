package com.example.cw1.service;

import com.example.cw1.model.EJIEmployee;
import com.example.cw1.repository.EJIEmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EJIEmployeeService {
    private final EJIEmployeeRepo employeeRepo;

    public EJIEmployeeService(EJIEmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public EJIEmployee createEmployee(EJIEmployee employee) {
        return employeeRepo.save(employee);
    }

    public List<EJIEmployee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<EJIEmployee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }
}
