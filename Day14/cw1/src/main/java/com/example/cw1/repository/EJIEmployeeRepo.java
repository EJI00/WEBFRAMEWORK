package com.example.cw1.repository;
import com.example.cw1.model.EJIEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EJIEmployeeRepo extends JpaRepository<EJIEmployee, Long> {
}
