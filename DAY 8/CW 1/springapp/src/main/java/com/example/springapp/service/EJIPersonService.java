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

    public List<EJIPerson> start(String value)
    {
        return rep.findByNameStartingWith(value);
    }

    public List<EJIPerson> end(String value)
    {
        return rep.findByNameEndingWith(value);
    }
    
}
