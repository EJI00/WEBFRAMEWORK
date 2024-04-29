package com.example.cw1.controller;

import com.example.cw1.model.EJIEmployee;
import com.example.cw1.service.EJIEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EJIEmployeeController {
    private final EJIEmployeeService employeeService;

    public EJIEmployeeController(EJIEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EJIEmployee> createEmployee(@RequestBody EJIEmployee employee) {
        EJIEmployee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<List<EJIEmployee>> getAllEmployees() {
        List<EJIEmployee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EJIEmployee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<EJIEmployee> employee = employeeService.getEmployeeById(employeeId);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

