package com.netz00.libraryapp.repository;

import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.domain.projection.BookEntityOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByAuthor_IdEqualsAllIgnoreCase(Long id);

    List<Book> findByAuthor_NameEqualsIgnoreCase(String name);

    @Transactional
    @Modifying
    @Query("update Book b set b.author = NULL where b.author.id = ?1")
    void updateAuthorByAuthor_IdEquals(Long id);


    @Query("SELECT s FROM Book s")
    List<BookEntityOnly> custom_findAll();


}
