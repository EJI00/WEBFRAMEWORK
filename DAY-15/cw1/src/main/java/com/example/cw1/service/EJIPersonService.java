package com.example.cw1.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cw1.model.EJIPerson;
import com.example.cw1.repository.EJIPersonRepo;

@Service
public class EJIPersonService {
    @Autowired
    private EJIPersonRepo repo;

    public EJIPerson createPerson(EJIPerson person) {
        return repo.save(person);
    }

    public List<EJIPerson> getAllPersons() {
        return repo.findAll();
    }
}
