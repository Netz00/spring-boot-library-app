package com.netz00.libraryapp.service;

import com.netz00.libraryapp.domain.Author;
import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.repository.BookRepository;
import com.netz00.libraryapp.repository.LendingRepository;
import com.netz00.libraryapp.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

/**
 * Tests for {@link BookServiceImpl}.
 */
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private LendingRepository lendingRepository;

    @Test
    void findByAuthor_IdShouldReturnUser() {

        Author author = new Author("Martin", "Fowler", 1970, null, "male", "Five star general");
        Book book = new Book("123456789012", "The little black book", null, null, null, author);

        given(this.bookRepository.findByAuthor_IdEqualsAllIgnoreCase(anyLong())).willReturn(List.of(book));

        List<Book> result = this.bookService.findAll(anyLong());

        assertThat(result).contains(book);
    }

}
