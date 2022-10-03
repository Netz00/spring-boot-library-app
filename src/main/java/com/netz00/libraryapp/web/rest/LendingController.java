package com.netz00.libraryapp.web.rest;

import com.netz00.libraryapp.domain.Lending;
import com.netz00.libraryapp.domain.User;
import com.netz00.libraryapp.domain.enumeration.LendingStatus;
import com.netz00.libraryapp.domain.projection.LendingBookOnly;
import com.netz00.libraryapp.domain.projection.LendingEntityOnly;
import com.netz00.libraryapp.domain.projection.LendingUserOnly;
import com.netz00.libraryapp.exception.LendingDoesNotExistsException;
import com.netz00.libraryapp.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/lendings")
public class LendingController {
    LendingService lendingService;

    @Autowired
    public LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @GetMapping
    public List<LendingEntityOnly> findAll() {
        return lendingService.findAll();
    }

    @GetMapping(path = "{lendingId}")
    public Lending getLending(@PathVariable Long lendingId) throws LendingDoesNotExistsException {
        return lendingService.findById(lendingId);
    }

    @GetMapping(path = "new")
    @ResponseStatus(HttpStatus.CREATED)
    public Lending registerNewLending(@RequestParam(required = true) Long userId, @RequestParam(required = true) Long bookId, @RequestParam(required = false) String note) {
        return lendingService.lendBook(userId, bookId, note);
    }


    @PatchMapping(path = "{lendingId}")
    public Lending updateLending(@PathVariable Long lendingId, @RequestBody Lending lending) throws LendingDoesNotExistsException {
        return lendingService.patchLending(lendingId, lending);
    }


    @DeleteMapping(path = "{lendingId}")
    public void deleteLending(@PathVariable Long lendingId) throws LendingDoesNotExistsException {
        lendingService.deleteLending(lendingId);
    }


    @PatchMapping(path = "{lendingId}/return")
    public Lending returnBook(@PathVariable Long lendingId, @RequestParam(required = false) String note) throws LendingDoesNotExistsException {
        return lendingService.returnBook(lendingId, note);
    }

    @GetMapping(path = "user/{userId}")
    public List<LendingBookOnly> findAllByUser(@PathVariable(required = true) Long userId, @RequestParam(required = false) LendingStatus status) {
        return lendingService.findAll(userId, status);
    }

    @GetMapping(path = "book/{bookId}")
    public List<LendingUserOnly> findAllByBook(@PathVariable(required = true) String bookId, @RequestParam(required = false) LendingStatus status) {
        return lendingService.findAll(bookId, status);
    }


    @GetMapping(path = "status")
    public List<Lending> findAllByStatus(@RequestParam(required = false) LendingStatus status) {
        return lendingService.findAllByStatus(status);
    }


    @GetMapping(path = "period")
    public List<Lending> findAllPeriod(@RequestParam(required = true) Timestamp start, @RequestParam(required = true) Timestamp end, @RequestParam(required = false) LendingStatus status) {
        return lendingService.findAllPeriod(start, end, status);
    }

    @GetMapping(path = "period/users")
    public HashSet<User> findAllUsersPeriod(@RequestParam(required = true) Timestamp start, @RequestParam(required = true) Timestamp end, @RequestParam(required = false) LendingStatus status) {
        return lendingService.findAllUsersPeriod(start, end, status);
    }

}
