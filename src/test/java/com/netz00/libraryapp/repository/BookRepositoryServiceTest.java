package com.netz00.libraryapp.repository;


import com.netz00.libraryapp.domain.Author;
import com.netz00.libraryapp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link BookRepository}.
 */
@DataJpaTest
public class BookRepositoryServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository repository;


    @Test
    void findByAuthor_IdShouldReturnUser() {

        Author author = new Author("Martin", "Fowler", 1970, null, "male", "Five star general");
        this.entityManager.persist(author);

        Book book = new Book("123456789012", "The little black book", null, null, null, author);
        this.entityManager.persist(book);

        Long authorId = author.getId();
        List<Book> result = this.repository.findByAuthor_IdEqualsAllIgnoreCase(authorId);

        assertThat(result).contains(book);

    }


    @Test
    void findByAuthor_IdWhenNoBooksShouldReturnEmpty() {

        Author author = new Author("Martin", "Fowler", 1970, null, "male", "Five star general");
        this.entityManager.persist(author);

        Long authorId = author.getId();

        List<Book> result = this.repository.findByAuthor_IdEqualsAllIgnoreCase(authorId);
        assertThat(result).isEmpty();
    }


}
