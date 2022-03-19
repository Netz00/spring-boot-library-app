package com.netz00.libraryapp.exception;

public class UserDoesNotExistsException extends RuntimeException{
    public UserDoesNotExistsException(Long userId){
        super("User with ID " + userId + " does not exists.");
    }
}