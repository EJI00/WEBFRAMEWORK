package com.example.ce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.EJIEmployee;
import com.example.ce1.service.EJIEmployeeService;

@RestController
public class EJIEmployeeController {
    @Autowired
    EJIEmployeeService employeeService;

    @PostMapping("/employee")
    public EJIEmployee setMethod(@RequestBody EJIEmployee employee)
    {
        return employeeService.setEmployee(employee);
    }

    @GetMapping("/employees-inner-join")
    public List<EJIEmployee> getInnerMethod()
    {
        return employeeService.getInnerEmployee();
    }

    @GetMapping("/employees-left-outer-join")
    public List<EJIEmployee> getLeftMethod()
    {
        return employeeService.getLeftOuterEmployee();
    }
}
