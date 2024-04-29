package com.example.cw1.controller;

import com.example.cw1.model.EJIPayroll;
import com.example.cw1.service.EJIPayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/{employeeId}/payroll")
public class EJIPayrollController {
    private final EJIPayrollService payrollService;

    public EJIPayrollController(EJIPayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<EJIPayroll> createPayrollForEmployee(@PathVariable Long employeeId, @RequestBody EJIPayroll payroll) {
        EJIPayroll createdPayroll = payrollService.createPayroll(payroll);
        if (createdPayroll != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayroll);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping
    public ResponseEntity<EJIPayroll> getPayrollForEmployee(@PathVariable Long employeeId) {
        EJIPayroll payroll = payrollService.getPayrollByEmployeeId(employeeId);
        if (payroll != null) {
            return ResponseEntity.ok(payroll);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
