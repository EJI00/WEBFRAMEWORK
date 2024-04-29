package com.example.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.EJIAuthor;
import com.example.q1.repository.EJIAuthorRepository;

@Service
public class EJIAuthorService {
    @Autowired
    private EJIAuthorRepository authorRepository;

    public EJIAuthor saveAuthor(EJIAuthor author) {
        return authorRepository.save(author);
    }

    public EJIAuthor getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<EJIAuthor> getAllAuthors() {
        return authorRepository.findAll();
    }

    public EJIAuthor updateAuthor(Long id, EJIAuthor author) {
        EJIAuthor existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setPhoneNumber(author.getPhoneNumber());
            existingAuthor.setAddress(author.getAddress());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
