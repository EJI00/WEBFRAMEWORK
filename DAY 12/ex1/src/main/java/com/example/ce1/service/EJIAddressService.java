package com.example.ce1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ce1.model.EJIAddress;
import com.example.ce1.repository.EJIAddressRepo;
import com.example.ce1.repository.EJIEmployeeRepo;

@Service
public class EJIAddressService {
    @Autowired
    EJIAddressRepo addressRepo;
    @Autowired
    EJIEmployeeRepo employeeRepo;
    public EJIAddress setAddressById(int id,EJIAddress address)
    {
        if(employeeRepo.existsById(id))
        {
            addressRepo.setByemployeeId(address.getCity(), address.getStreet(), id);
            return address;
        }
        else
        {
            return null;
        }
    }
}
