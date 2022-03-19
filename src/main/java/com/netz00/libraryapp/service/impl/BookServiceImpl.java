package com.netz00.libraryapp.service.impl;

import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.repository.BookRepository;
import com.netz00.libraryapp.repository.LendingRepository;
import com.netz00.libraryapp.service.BookService;
import com.netz00.libraryapp.exception.BookDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    LendingRepository lendingRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, LendingRepository lendingRepository) {
        this.bookRepository = bookRepository;
        this.lendingRepository = lendingRepository;
    }

    /**
     * TODO
     * findAll methods refuse to do lazy fetching and also answer with N+1 query
     *
     * @return
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * TODO
     * findAll methods refuse to do lazy fetching
     *
     * @return
     */
    @Override
    public Book findById(String id) throws BookDoesNotExistsException {
        return bookRepository.findById(id).orElseThrow(() -> new BookDoesNotExistsException(id));
    }

    @Override
    public Book addNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book deleteBook(String id) throws BookDoesNotExistsException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookDoesNotExistsException(id));

        lendingRepository.updateBookByBook_IdEquals(id);

        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book patchBook(String id, Book book) throws BookDoesNotExistsException {
        Book currentBook = bookRepository.findById(id).orElseThrow(() -> new BookDoesNotExistsException(id));
        bookRepository.delete(book);

        if (book.getName() != null) currentBook.setName(book.getName());

        if (book.getAuthor() != null) currentBook.setAuthor(book.getAuthor());

        if (book.getIsbn() != null) currentBook.setIsbn(book.getIsbn());

        if (book.getCreated_date() != null) currentBook.setCreated_date(book.getCreated_date());

        if (book.getPublisher() != null) currentBook.setPublisher(book.getPublisher());

        if (book.getYear() != null) currentBook.setYear(book.getYear());

        if (book.getLast_modified_date() != null) currentBook.setLast_modified_date(book.getLast_modified_date());

        if (book.getNote() != null) currentBook.setNote(book.getNote());

        return bookRepository.save(currentBook);
    }

    @Override
    public List<Book> findAll(Long author) {
        return bookRepository.findByAuthor_IdEqualsAllIgnoreCase(author);
    }
}
