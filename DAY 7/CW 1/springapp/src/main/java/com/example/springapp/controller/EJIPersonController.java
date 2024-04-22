package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.EJIPerson;
import com.example.springapp.service.EJIPersonService;

@RestController
public class EJIPersonController {
    @Autowired
    private EJIPersonService ser;
    
    @PostMapping("/api/person")
    public ResponseEntity<EJIPerson> post(@RequestBody EJIPerson person)
    {
        if(ser.post(person))
        {
            return new ResponseEntity<>(person,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/person")
    public ResponseEntity<List<EJIPerson>> getAll()
    {
        List<EJIPerson> li = ser.getAll();
        if(li.size()>0)
        {
            return new ResponseEntity<>(li,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/person/byAge")
    public ResponseEntity<List<EJIPerson>> getbyAge(@RequestParam int age)
    {
        List<EJIPerson> li = ser.getbyAge(age);
        if(li.size()>0)
        {
            return new ResponseEntity<>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
