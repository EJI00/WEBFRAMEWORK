package com.example.q1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.EJIAuthor;
import com.example.q1.model.EJIBook;
import com.example.q1.repository.EJIAuthorRepository;
import com.example.q1.repository.EJIBookRepository;

@Service
public class EJIBookService {
    @Autowired
    private EJIBookRepository bookRepository;
@Autowired
private EJIAuthorRepository authorRepository;
    public EJIBook saveBook(Long authorId, EJIBook book) {
        EJIAuthor author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            book.setAuthor(author);
            author.getBooks().add(book);
            return bookRepository.save(book);
        }
        return null;
    }

    public EJIBook getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

