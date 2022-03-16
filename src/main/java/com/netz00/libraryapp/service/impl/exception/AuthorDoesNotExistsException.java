package com.netz00.libraryapp.service.impl.exception;

public class AuthorDoesNotExistsException extends RuntimeException{
    public AuthorDoesNotExistsException(Long authorId){
        super("Author with ID " + authorId + " does not exists.");
    }
}