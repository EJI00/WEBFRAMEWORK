package com.example.cw2.controller;

import com.example.cw2.model.EJIBook;
import com.example.cw2.service.EJIBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class EJIBookController {
    private final EJIBookService bookService;

    public EJIBookController(EJIBookService BookService) {
        this.bookService = BookService;
    }

    @PostMapping
    public ResponseEntity<EJIBook> createBook(@RequestBody EJIBook Book) {
        EJIBook createdBook = bookService.createBook(Book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<EJIBook>> getAllBooks() {
        List<EJIBook> Books = bookService.getAllBooks();
        return ResponseEntity.ok(Books);
    }
    @PutMapping("/{bookId}")
    public EJIBook updateBookById(@PathVariable Long bookId,@RequestBody EJIBook book){
        EJIBook b = bookService.updateBookById(bookId, book);
        return b;
    }
    @GetMapping("/{bookId}")
    public EJIBook getBookById(@PathVariable Long bookId) {
        EJIBook book = bookService.getBookById(bookId);
        return book;
    }
}
