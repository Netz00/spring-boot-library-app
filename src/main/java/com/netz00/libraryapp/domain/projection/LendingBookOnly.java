package com.netz00.libraryapp.domain.projection;


import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.domain.enumeration.LendingStatus;

public interface LendingBookOnly {

    public Long getId();

    public LendingStatus getStatus();

    public String getNote();

    public Book getBook();

}
