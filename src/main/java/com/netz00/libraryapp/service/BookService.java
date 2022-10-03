package com.netz00.libraryapp.service;

import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.domain.projection.BookEntityOnly;

import java.util.List;

public interface BookService {

    public List<BookEntityOnly> findAll();

    public Book findById(Long id);

    public Book addNewBook(Book book);

    public Book deleteBook(Long id);

    public Book patchBook(Long id, Book book);


    /**
     *  Find all books of certain author
     */
    public List<Book> findAll(Long authorId);

}
