package com.netz00.libraryapp.exception;

public class LendingDoesNotExistsException extends RuntimeException{
    public LendingDoesNotExistsException(Long lendingId){
        super("Lending with ID " + lendingId + " does not exists.");
    }
}