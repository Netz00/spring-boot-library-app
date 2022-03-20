package com.netz00.libraryapp.web.rest;

import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.domain.projection.BookEntityOnly;
import com.netz00.libraryapp.exception.BookDoesNotExistsException;
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
    public List<BookEntityOnly> findAll() {
        return bookService.findAll();
    }

    @GetMapping(path = "{bookId}")
    public Book getBook(@PathVariable String bookId) throws BookDoesNotExistsException {
        return bookService.findById(bookId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book registerNewBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable String bookId) throws BookDoesNotExistsException {
        bookService.deleteBook(bookId);
    }

    @PatchMapping(path = "{bookId}")
    public Book updateBook(@PathVariable String bookId, @RequestBody Book book) throws BookDoesNotExistsException {
        return bookService.patchBook(bookId, book);
    }

    @GetMapping(path = "author")
    public List<Book> findAllByAuthorId(@RequestParam Long authorId) {
        return bookService.findAll(authorId);
    }

}
