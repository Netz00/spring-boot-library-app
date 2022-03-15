package com.netz00.libraryapp.service;

import com.netz00.libraryapp.domain.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> findAll();

    public Author findById(Long id);

    public Author addNewAuthor(Author author);

    public Author deleteAuthor(Long id);

    public Author patchAuthor(Long id, Author author);

}

