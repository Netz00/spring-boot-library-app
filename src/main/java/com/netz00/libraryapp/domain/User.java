package com.netz00.libraryapp.domain;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        })
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "family_name",
            nullable = false
    )
    private String family_name;

    @Column(
            name = "date_birth",
            nullable = false
    )
    private LocalDate date_birth;

    @Column(
            name = "date_joining",
            nullable = false
    )
    private LocalDate date_joining;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    @Column(
            name = "mobile",
            nullable = false
    )
    private String mobile;

    @Column(
            name = "address",
            nullable = false
    )
    private String address;

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


    public User() {
    }

    public User(String name, String family_name, LocalDate date_birth, LocalDate date_joining, String email, String mobile, String address, String note, LocalDate last_modified_date) {
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

    public LocalDate getDate_joining() {
        return date_joining;
    }

    public void setDate_joining(LocalDate date_joining) {
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

    public LocalDate getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(LocalDate last_modified_date) {
        this.last_modified_date = last_modified_date;
    }
}
