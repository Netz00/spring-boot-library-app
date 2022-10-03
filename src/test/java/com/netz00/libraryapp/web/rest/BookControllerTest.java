package com.netz00.libraryapp.web.rest;


import com.netz00.libraryapp.domain.Book;
import com.netz00.libraryapp.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * {@code @WebMvcTest} based tests for {@link BookController}.
 */
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private BookServiceImpl bookService;

    @Test
    void getVehicleWhenRequestingTextShouldReturnMakeAndModel() throws Exception {

        Book book = new Book("123456789012", "The little black book", null, null, null, null);


        Instant created_at = book.getCreated_date();

        given(this.bookService.findById(anyLong())).willReturn(book);
        this.mvc.perform(get("/api/v1/books/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":null,\"isbn\":\"123456789012\",\"name\":\"The little black book\",\"publisher\":null,\"year\":null,\"note\":null,\"created_date\":\"" + created_at + "\",\"last_modified_date\":null,\"author\":null}"));
    }
}
