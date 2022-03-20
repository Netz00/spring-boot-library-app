package com.netz00.libraryapp.service;

import com.netz00.libraryapp.domain.Lending;
import com.netz00.libraryapp.domain.User;
import com.netz00.libraryapp.domain.enumeration.LendingStatus;
import com.netz00.libraryapp.domain.projection.LendingBookOnly;
import com.netz00.libraryapp.domain.projection.LendingEntityOnly;
import com.netz00.libraryapp.domain.projection.LendingUserOnly;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;

public interface LendingService {


    // -------------- BASIC CRUD --------------

    /**
     * Read all lendings
     */
    public List<LendingEntityOnly> findAll();

    /**
     * Read lending by lending.id
     */
    public Lending findById(Long lendingId);

    /**
     * Creates new lending
     */
    public Lending lendBook(Long userId, String bookId, String note);

    /**
     * Update lending corresponding to lending.id
     */
    public Lending patchLending(Long lendingId, Lending lending);

    /**
     * Delete lending
     */
    public Lending deleteLending(Long id);

    // ----------------------------------------

    /**
     * Finds lending by lending.id and changes state
     */
    public Lending returnBook(Long id, String note);

    /**
     * Finds all lending of single user
     */
    public List<LendingBookOnly> findAll(Long userId, LendingStatus status);

    /**
     * Finds all lending of single book
     */
    public List<LendingUserOnly> findAll(String book, LendingStatus status);

    /**
     * Finds all landings with state lended
     */
    public List<Lending> findAllByStatus(LendingStatus status);


    /**
     * Finds all lendings under given date range(with given state)
     */
    public List<Lending> findAllPeriod(Timestamp start, Timestamp end, LendingStatus status);


    /**
     * Find all users that read book under certain period(status RETURNED)
     */
    public HashSet<User> findAllUsersPeriod(Timestamp start, Timestamp end, LendingStatus status);

}
