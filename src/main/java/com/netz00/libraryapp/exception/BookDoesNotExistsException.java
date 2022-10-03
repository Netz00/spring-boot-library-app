package com.netz00.libraryapp.exception;

public class BookDoesNotExistsException extends RuntimeException{
    public BookDoesNotExistsException(Long bookId){
        super("Book with ID " + bookId.toString() + " does not exists.");
    }
}