package com.netz00.libraryapp.web.rest;

import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {
    BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping(path = "{bookId}")
    public Book getBook(@PathVariable String bookId) {
        return bookService.findById(bookId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book registerNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable String bookId) {
        bookService.deleteBook(bookId);
    }

    @PatchMapping(path = "{bookId}")
    public Book updateBook(@PathVariable String bookId,
                           @RequestBody Book book
    ) {
        return bookService.patchBook(bookId, book);
    }

    @GetMapping
    public List<Book> findAllByAuthorId(@RequestParam Long authorId) {
        return bookService.findAll(authorId);
    }
    
}
