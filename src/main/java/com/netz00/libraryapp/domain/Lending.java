package com.netz00.libraryapp.domain;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * ManyToMany Join table for User - Book relationship
 */
@Entity
@Table(
        name = "lending"
)
public class Lending {

    @Id
    @SequenceGenerator(
            name = "lending_sequence",
            sequenceName = "lending_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "lending_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "date_lending",
            nullable = false
    )
    private LocalDate date_lending;

    @Column(
            name = "date_returning",
            nullable = true
    )
    private LocalDate date_returning;

    /**
     * TODO
     * define statuses as ENUMS
     */
    @Column(
            name = "status",
            nullable = false
    )
    private String status;

    @Column(
            name = "note",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String note;

    @Column(
            name = "last_modified_date",
            nullable = false
    )
    private LocalDate last_modified_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    User user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "id"
    )
    Book book_id;

    public Lending() {
    }

    public Lending(LocalDate date_lending, LocalDate date_returning, String status, String note, LocalDate last_modified_date, User user_id, Book book_id) {
        this.date_lending = date_lending;
        this.date_returning = date_returning;
        this.status = status;
        this.note = note;
        this.last_modified_date = last_modified_date;
        this.user_id = user_id;
        this.book_id = book_id;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate_lending() {
        return date_lending;
    }

    public void setDate_lending(LocalDate date_lending) {
        this.date_lending = date_lending;
    }

    public LocalDate getDate_returning() {
        return date_returning;
    }

    public void setDate_returning(LocalDate date_returning) {
        this.date_returning = date_returning;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(LocalDate last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }
}
