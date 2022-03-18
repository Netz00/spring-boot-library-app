package com.netz00.libraryapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "author"
)
public class Author {

    @Id
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "author_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Size(min = 1, max = 30, message = "Name must be between 1 and 30 characters")
    @NotEmpty(message = "Name is required. Name cannot be null or empty")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 0, max = 30, message = "Family name must be up to 30 characters max")
    @Column(name = "family_name", nullable = true)
    private String family_name;


    @Column(name = "birth_year", nullable = true)
    private Integer birth_year;


    @Column(name = "death_year", nullable = true)
    private Integer death_year;


    /**
     * TODO
     * define genres as separate relation or even ENUMS
     */
    @Column(name = "genre", nullable = true)
    private String genre;

    @Size(min = 0, max = 200, message = "Note must be up to 200 characters max")
    @Column(name = "note", nullable = true, columnDefinition = "TEXT")
    private String note;


    public Author() {
    }

    public Author(String name, String family_name, Integer birth_year, Integer death_year, String genre, String note) {
        this.name = name;
        this.family_name = family_name;
        this.birth_year = birth_year;
        this.death_year = death_year;
        this.genre = genre;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", family_name='" + family_name + '\'' +
                ", birth_year=" + birth_year +
                ", death_year=" + death_year +
                ", genre='" + genre + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
