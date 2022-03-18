package com.netz00.libraryapp.service.impl.exception;

public class UserDoesNotExistsException extends RuntimeException{
    public UserDoesNotExistsException(Long userId){
        super("User with ID " + userId + " does not exists.");
    }
}