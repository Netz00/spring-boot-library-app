package com.netz00.libraryapp.domain.projection;


import com.netz00.libraryapp.domain.enumeration.LendingStatus;

import java.sql.Timestamp;

public interface LendingEntityOnly {

    public Long getId();

    public Timestamp getDate_lending();

    public Timestamp getDate_returning();

    public LendingStatus getStatus();

    public String getNote();

    public Timestamp getLast_modified_date();

}
