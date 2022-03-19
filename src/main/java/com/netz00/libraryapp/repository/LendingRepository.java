package com.netz00.libraryapp.repository;

import com.netz00.libraryapp.domain.Lending;
import com.netz00.libraryapp.domain.User;
import com.netz00.libraryapp.domain.enumeration.LendingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LendingRepository extends JpaRepository<Lending, Long> {

    List<Lending> findByUser_idEqualsAndStatusEquals(User userId, LendingStatus status);

    @Transactional
    @Modifying
    @Query("update Lending l set l.book = NULL where l.book.id = ?1")
    void updateBookByBook_IdEquals(String id);


}
