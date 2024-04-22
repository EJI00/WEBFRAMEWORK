package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.EJIPerson;
import com.example.springapp.repository.EJIPersonRepo;

@Service
public class EJIPersonService {
    @Autowired
    private EJIPersonRepo rep;

    public boolean post(EJIPerson person)
    {
        try
        {
            rep.save(person);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<EJIPerson> getAll()
    {
        return rep.findAll();
    }

    public List<EJIPerson> getbyAge(int age)
    {
        return rep.findByAge(age);
    }
    
}
