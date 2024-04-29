package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.EJIStudentDetail;
import com.example.springapp.repository.EJIStudentDetailRepository;
import com.example.springapp.repository.EJIStudentRepository;

@Service
public class EJIStudentDetailService {
    @Autowired
    EJIStudentDetailRepository studentDetailRepository;
    @Autowired
    EJIStudentRepository studentRepository;
    public EJIStudentDetail addStudentDetail(int id,EJIStudentDetail studentDetail)
    {
        if(studentRepository.existsById(id))
        {
            studentDetailRepository.addStudentDetail(studentDetail.getAddress(),studentDetail.getPhoneNumber(),id);
            return studentDetail;
        }
        else
        return null;
    }
    
    
}
