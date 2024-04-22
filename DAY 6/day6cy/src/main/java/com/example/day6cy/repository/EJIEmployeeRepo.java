package com.example.day6cy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day6cy.model.EJIEmployee;

public interface EJIEmployeeRepo extends JpaRepository<EJIEmployee,Integer>{
    
}
