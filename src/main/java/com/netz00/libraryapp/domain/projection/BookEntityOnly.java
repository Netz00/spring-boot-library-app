package com.netz00.libraryapp.domain.projection;

import java.sql.Timestamp;

public interface BookEntityOnly {

    public String getId();

    public String getIsbn();

    public String getName();

    public String getPublisher();

    public Integer getYear();

    public String getNote();

    public Timestamp getCreated_date();

    public Timestamp getLast_modified_date();


}
