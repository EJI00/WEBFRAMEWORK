package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.EJIStudent;
import com.example.springapp.repository.EJIStudentRepository;

@Service
public class EJIStudentService {
    @Autowired
    EJIStudentRepository studentRepository;
    public EJIStudent addStudents(EJIStudent student)
    {
        return studentRepository.save(student);
    }
    public List<EJIStudent>getStudent()
    {
        return studentRepository.findAll();
    }
    public List<EJIStudent>getStudentInner()
    {
        return studentRepository.getStudentInner();
    }
    public List<EJIStudent>getStudentLeftOuter()
    {
        return studentRepository.getStudentsLeftOuter();
    }
    
}
