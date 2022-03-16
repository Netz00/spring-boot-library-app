package com.netz00.libraryapp.repository;

import com.netz00.libraryapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByAuthor_IdEqualsAllIgnoreCase(Long id);

    List<Book> findByAuthor_NameEqualsIgnoreCase(String name);


}
