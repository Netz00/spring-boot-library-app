package com.netz00.libraryapp.service.impl;

import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.domain.Lending;
import com.netz00.libraryapp.domain.User;
import com.netz00.libraryapp.domain.enumeration.LendingStatus;
import com.netz00.libraryapp.domain.projection.LendingBookOnly;
import com.netz00.libraryapp.domain.projection.LendingEntityOnly;
import com.netz00.libraryapp.domain.projection.LendingUserOnly;
import com.netz00.libraryapp.exception.BookDoesNotExistsException;
import com.netz00.libraryapp.exception.LendingDoesNotExistsException;
import com.netz00.libraryapp.exception.UserDoesNotExistsException;
import com.netz00.libraryapp.repository.BookRepository;
import com.netz00.libraryapp.repository.LendingRepository;
import com.netz00.libraryapp.repository.UserRepository;
import com.netz00.libraryapp.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class LendingServiceImpl implements LendingService {

    LendingRepository lendingRepository;
    UserRepository userRepository;
    BookRepository bookRepository;


    @Autowired
    public LendingServiceImpl(LendingRepository lendingRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.lendingRepository = lendingRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    @Transactional
    public Lending returnBook(Long id, String note) {
        Lending lending = lendingRepository.findById(id).orElseThrow(() -> new LendingDoesNotExistsException(id));

        if (note != null) lending.setNote(note);

        lending.setStatus(LendingStatus.RETURNED);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        lending.setDate_returning(timestamp);
        lending.setLast_modified_date(timestamp);

        return lending;
    }


    @Override
    public List<LendingEntityOnly> findAll() {
        return lendingRepository.custom_findAll();
    }


    @Override
    public Lending lendBook(Long userId, String bookId, String note) throws UserDoesNotExistsException {

        User user = userRepository.findById(userId).orElseThrow(() -> new UserDoesNotExistsException(userId));


        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookDoesNotExistsException(bookId));


        Lending lending = new Lending();

        lending.setStatus(LendingStatus.LENDED);
        lending.setNote(note);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        lending.setDateLending(timestamp);

        lending.setUser(user);
        lending.setBook(book);

        return lendingRepository.save(lending);
    }


    @Override
    public Lending findById(Long lendingId) {
        return lendingRepository.findById(lendingId).orElseThrow(() -> new LendingDoesNotExistsException(lendingId));
    }


    @Override
    public Lending deleteLending(Long id) {
        Lending lending = lendingRepository.findById(id).orElseThrow(() -> new LendingDoesNotExistsException(id));

        lendingRepository.deleteById(id);

        return lending;
    }

    @Transactional
    @Override
    public Lending patchLending(Long id, Lending lending) {

        Lending oldLending = lendingRepository.findById(id).orElseThrow(() -> new LendingDoesNotExistsException(id));

        boolean updated = false;

        if (lending.getNote() != null) {
            oldLending.setNote(lending.getNote());
            updated = true;
        }

        if (lending.getStatus() != null) {
            oldLending.setStatus(lending.getStatus());
            updated = true;
        }

        if (updated) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            lending.setLast_modified_date(timestamp);
        }

        return oldLending;
    }


    /**
     * TODO
     * JPA Hibernate problems, doing queries no one asked for
     *
     * @param userId
     * @param status
     * @return
     */

    @Override
    public List<LendingBookOnly> findAll(Long userId, LendingStatus status) {
        if (status == null)
            return lendingRepository.findByUser_IdEquals(userId);
        return lendingRepository.findByUser_IdEqualsAndStatusEquals(userId, status);
    }


    /**
     * TODO
     * JPA Hibernate problems, again Joinung user table for no reason!
     *
     * @param bookId
     * @param status
     * @return
     */

    @Override
    public List<LendingUserOnly> findAll(String bookId, LendingStatus status) {
        if (status == null)
            return lendingRepository.findByBook_IdEquals(bookId);
        return lendingRepository.findByBook_IdEqualsAndStatusEquals(bookId, status);
    }


    @Override
    public List<Lending> findAllByStatus(LendingStatus status) {
        return lendingRepository.findByStatusEquals(status);
    }


    @Override
    public List<Lending> findAllPeriod(Timestamp start, Timestamp end, LendingStatus status) {
        if (status == null)
            return lendingRepository.findByDateLendingIsBetween(start, end);

        return lendingRepository.findByDateLendingIsBetweenAndStatusEquals(start, end, status);
    }


    @Override
    public HashSet<User> findAllUsersPeriod(Timestamp start, Timestamp end, LendingStatus status) {

        List<Lending> lendings;

        if (status == null)
            lendings = lendingRepository.findByDateLendingIsBetween(start, end);
        else
            lendings = lendingRepository.findByDateLendingIsBetweenAndStatusEquals(start, end, status);

        if (lendings.isEmpty())
            return null;

        HashSet<User> users = new HashSet<>(); // no duplicates :)

        for (Lending lending : lendings
        ) {
            users.add(lending.getUser());
        }

        return users;
    }
}
