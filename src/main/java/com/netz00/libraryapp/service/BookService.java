package com.netz00.libraryapp.service;

import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.domain.projection.BookEntityOnly;

import java.util.List;

public interface BookService {

    public List<BookEntityOnly> findAll();

    public Book findById(String id);

    public Book addNewBook(Book book);

    public Book deleteBook(String id);

    public Book patchBook(String id, Book book);


    /**
     *  Find all books of certain author
     */
    public List<Book> findAll(Long authorId);

}
