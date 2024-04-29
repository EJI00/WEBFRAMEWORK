package com.example.ce1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.EJIEmployee;
import com.example.ce1.repository.EJIEmployeeRepo;

@Service
public class EJIEmployeeService {
    @Autowired
    EJIEmployeeRepo employeeRepo;

    @SuppressWarnings("null")
    public EJIEmployee setEmployee(EJIEmployee employee)
    {
        return employeeRepo.save(employee);
    }

    public List<EJIEmployee> getInnerEmployee()
    {
        return employeeRepo.getByInnerEmployees();
    }

    public List<EJIEmployee> getLeftOuterEmployee()
    {
        return employeeRepo.getByLeftOuterEmployees();
    }
}
