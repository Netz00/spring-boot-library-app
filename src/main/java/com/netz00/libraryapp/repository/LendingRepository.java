package com.netz00.libraryapp.repository;

import com.netz00.libraryapp.domain.Lending;
import com.netz00.libraryapp.domain.User;
import com.netz00.libraryapp.domain.enumeration.LendingStatus;
import com.netz00.libraryapp.domain.projection.LendingBookOnly;
import com.netz00.libraryapp.domain.projection.LendingEntityOnly;
import com.netz00.libraryapp.domain.projection.LendingUserOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface LendingRepository extends JpaRepository<Lending, Long> {


    /**
     * Find all entities without relationships!
     *
     * @return
     */

    @Query("SELECT s FROM Lending s")
    List<LendingEntityOnly> custom_findAll();


    /**
     * Find all lended books by the user with given status
     *
     * @param userId who lended the book?
     * @param status LENDED/LOST...
     * @return
     */

    List<LendingBookOnly> findByUser_IdEqualsAndStatusEquals(@NonNull Long userId, @NonNull LendingStatus status);

    List<LendingBookOnly> findByUser_IdEquals(@NonNull Long userId);


    /**
     * Find all book lendings with given status
     *
     * @param bookId
     * @param status
     * @return
     */
    List<LendingUserOnly> findByBook_IdEqualsAndStatusEquals(@NonNull String bookId, @NonNull LendingStatus status);

    /**
     * Find all book lendings with no matter to status
     */
    List<LendingUserOnly> findByBook_IdEquals(@NonNull String bookId);


    /**
     * Find all books with given status
     */

    List<Lending> findByStatusEquals(LendingStatus status);


    List<Lending> findByDateLendingIsBetween(Timestamp date_lendingStart, Timestamp date_lendingEnd);

    List<Lending> findByDateLendingIsBetweenAndStatusEquals(Timestamp date_lendingStart, Timestamp date_lendingEnd, LendingStatus status);


    /**
     * Operation required to execute before removing Book to avoid FK constraint
     * and preserve data integrity
     *
     * @param id of the Book we are removing
     */
    @Transactional
    @Modifying
    @Query("update Lending l set l.book = NULL where l.book.id = ?1")
    void updateBookByBook_IdEquals(String id);


}
