package com.netz00.libraryapp.domain;


import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "book",
        uniqueConstraints = {
                @UniqueConstraint(name = "book_isbn_unique", columnNames = "isbn")
        })
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private String id;


    /**
     * TODO
     * strip hyphens and whitespace before inserting into
     * the database so that it will fit in 10 or 13 characters,
     * and to make search/querying easier
     */
    @Column(
            name = "isbn",
            nullable = false,
            columnDefinition = "CHAR(17)"
    )
    private String isbn;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "publisher",
            nullable = false
    )
    private String publisher;

    @Column(
            name = "year",
            nullable = false
    )
    private Integer year;

    @Column(
            name = "note",
            nullable = true,
            columnDefinition = "TEXT"
    )
    private String note;

    @Column(
            name = "created_date",
            nullable = false
    )
    private LocalDate created_date;

    @Column(
            name = "last_modified_date",
            nullable = false
    )
    private LocalDate last_modified_date;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id"
    )
    private Author author;


    public Book() {
    }

    public Book(String isbn, String name, String publisher, Integer year, String note, LocalDate created_date, LocalDate last_modified_date, Author author) {
        this.isbn = isbn;
        this.name = name;
        this.publisher = publisher;
        this.year = year;
        this.note = note;
        this.created_date = created_date;
        this.last_modified_date = last_modified_date;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public LocalDate getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(LocalDate last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", note='" + note + '\'' +
                ", createdDate=" + created_date +
                ", lastModifiedDate=" + last_modified_date +
                ", author=" + author +
                '}';
    }
}
