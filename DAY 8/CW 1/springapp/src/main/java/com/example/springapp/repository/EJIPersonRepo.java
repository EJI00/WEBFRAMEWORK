package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springapp.model.EJIPerson;
import java.util.List;


@Repository
public interface EJIPersonRepo extends JpaRepository<EJIPerson,Integer>{

    List<EJIPerson> findByNameStartingWith(String name);
    List<EJIPerson> findByNameEndingWith(String name);
    
}
