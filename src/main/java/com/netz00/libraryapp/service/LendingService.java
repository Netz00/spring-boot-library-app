package com.netz00.libraryapp.service;

import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.domain.Lending;
import com.netz00.libraryapp.domain.User;

import java.time.LocalDate;
import java.util.List;

public interface LendingService {

    /**
     * Creates new lending
     */
    public Lending lendBook(User user, Book book);

    /**
     * Finds lending by lending.id and changes state
     */
    public Lending returnBook(Long id);

    /**
     * Finds lending by lending.id
     */
    public Lending findById(Long id);


    /**
     * Updates lending corresponding to lending.id
     */
    public Lending patchLending(Long id, Lending lending);


    /**
     * Finds all lending of single book
     */
    public List<Lending> findAll(User user);

    /**
     * Finds all lending of single user
     */
    public List<Lending> findAll(Book book);


    /**
     * Finds all landings with state lended
     */
    public Lending findAllLanded();

    /**
     * Finds all landings with state lended under certain date range
     */
    public Lending findAllLandedPeriod(LocalDate start, LocalDate end);


    /**
     * Finds all landings under certain date range
     */
    public Lending findAllPeriod(LocalDate start, LocalDate end);

    /**
     * Find all users that read book under certain period
     */
    public Lending findAllUsersPeriod(LocalDate start, LocalDate end);

}
