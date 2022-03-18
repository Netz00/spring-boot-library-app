package com.netz00.libraryapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.sql.Timestamp;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(name = "user_email_unique", columnNames = "email")})
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "user_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    @NotEmpty(message = "Name is required. Name cannot be null or empty")
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 1, max = 50, message = "Family name must be between 1 and 50 characters")
    @NotEmpty(message = "Family name is required. Family name cannot be null or empty")
    @Column(name = "family_name", nullable = false)
    private String family_name;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date_birth", nullable = false)
    private LocalDate date_birth;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "date_joining", nullable = false)
    private Timestamp date_joining;

    @Size(min = 3, max = 50, message = "Email must be between 3 and 50 characters")
    @NotEmpty(message = "Email is required. Email cannot be null or empty")
    @Column(name = "email", nullable = false)
    private String email;

    @Size(min = 1, max = 50, message = "Mobile must be between 1 and 50 characters")
    @NotEmpty(message = "Mobile is required. Mobile cannot be null or empty")
    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Size(min = 1, max = 50, message = "Address must be between 1 and 50 characters")
    @NotEmpty(message = "Address is required. Address cannot be null or empty")
    @Column(name = "address", nullable = false)
    private String address;

    @Size(min = 0, max = 200, message = "Note must be up to 200 characters max")
    @Column(name = "note", nullable = true, columnDefinition = "TEXT")
    private String note;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "last_modified_date", nullable = true)
    private Timestamp last_modified_date;


    public User() {
    }

    public User(String name, String family_name, LocalDate date_birth, Timestamp date_joining, String email, String mobile, String address, String note, Timestamp last_modified_date) {
        this.name = name;
        this.family_name = family_name;
        this.date_birth = date_birth;
        this.date_joining = date_joining;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.note = note;
        this.last_modified_date = last_modified_date;
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

    public LocalDate getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(LocalDate date_birth) {
        this.date_birth = date_birth;
    }

    public Timestamp getDate_joining() {
        return date_joining;
    }

    public void setDate_joining(Timestamp date_joining) {
        this.date_joining = date_joining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
