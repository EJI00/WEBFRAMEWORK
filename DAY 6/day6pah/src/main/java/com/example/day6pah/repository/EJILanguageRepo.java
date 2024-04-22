package com.example.day6pah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day6pah.model.EJILanguage;

@Repository
public interface EJILanguageRepo extends JpaRepository<EJILanguage,Integer>{
    
}
