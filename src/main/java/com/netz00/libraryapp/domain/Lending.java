package com.netz00.libraryapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.netz00.libraryapp.domain.enumeration.LendingStatus;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.sql.Timestamp;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * ManyToMany Join table for User - Book relationship
 */
@Entity
@Table(name = "lending")
public class Lending {

    @Id
    @SequenceGenerator(name = "lending_sequence", sequenceName = "lending_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "lending_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    /**
     * Timestamp when Book was lended.
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "date_lending", nullable = false)
    private Timestamp date_lending;

    /**
     * Timestamp when Book was returned.
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "date_returning", nullable = true)
    private Timestamp date_returning;

    /**
     * Status of this Lending.
     */
    @NotEmpty(message = "Status is required. Status cannot be null or empty")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private LendingStatus status;

    /**
     * Note about this Lending.
     */
    @Size(min = 0, max = 200, message = "Note must be up to 200 characters max")
    @Column(name = "note", nullable = true, columnDefinition = "TEXT")
    private String note;

    /**
     * Timestamp when this Lending was last modified.
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "last_modified_date", nullable = true)
    private Timestamp last_modified_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    Book book;

    public Lending() {
    }

    public Lending(Timestamp date_lending, Timestamp date_returning, LendingStatus status, String note, Timestamp last_modified_date, User user, Book book) {
        this.date_lending = date_lending;
        this.date_returning = date_returning;
        this.status = status;
        this.note = note;
        this.last_modified_date = last_modified_date;
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getDate_lending() {
        return date_lending;
    }

    public void setDate_lending(Timestamp date_lending) {
        this.date_lending = date_lending;
    }

    public Timestamp getDate_returning() {
        return date_returning;
    }

    public void setDate_returning(Timestamp date_returning) {
        this.date_returning = date_returning;
    }

    public LendingStatus getStatus() {
        return status;
    }

    public void setStatus(LendingStatus status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Timestamp getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Timestamp last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
