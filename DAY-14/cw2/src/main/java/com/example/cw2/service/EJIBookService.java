package com.example.cw2.service;

import com.example.cw2.model.EJIBook;
import com.example.cw2.repository.EJIBookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EJIBookService {
    private final EJIBookRepo bookRepo;

    public EJIBookService(EJIBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public EJIBook createBook(EJIBook Book) {
        return bookRepo.save(Book);
    }
    public List<EJIBook> getAllBooks() {
        return bookRepo.findAll();
    }
    public EJIBook getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    public EJIBook updateBookById(Long id,EJIBook book){
        EJIBook b = bookRepo.findById(id).orElse(null);
        if(b!=null){
            b.setAuthor(book.getAuthor());
            b.setAvailableCopies(book.getAvailableCopies());
            b.setTitle(book.getTitle());
            b.setTotalCopies(book.getTotalCopies());
            bookRepo.save(b);
        }
        return b;
    }
}
