package com.example.cw1.service;

import com.example.cw1.model.EJIPayroll;
import com.example.cw1.repository.EJIPayrollRepo;
import org.springframework.stereotype.Service;

@Service
public class EJIPayrollService {
    private final EJIPayrollRepo payrollRepo;

    public EJIPayrollService(EJIPayrollRepo payrollRepo) {
        this.payrollRepo = payrollRepo;
    }

    public EJIPayroll createPayroll(EJIPayroll payroll) {
        return payrollRepo.save(payroll);
    }

    public EJIPayroll getPayrollByEmployeeId(Long employeeId) {
        return payrollRepo.findById(employeeId).orElse(null);
    }
}
