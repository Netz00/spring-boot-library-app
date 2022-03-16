package com.netz00.libraryapp.web.rest;

import com.netz00.libraryapp.domain.Author;
import com.netz00.libraryapp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/authors")
public class AuthorController {
    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping(path = "{authorId}")
    public Author getAuthor(@PathVariable Long authorId) {
        return authorService.findById(authorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author registerNewAuthor(@RequestBody Author author) {
        return authorService.addNewAuthor(author);
    }

    @DeleteMapping(path = "{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PatchMapping(path = "{authorId}")
    public Author updateAuthor(@PathVariable Long authorId,
                               @RequestBody Author author
    ) {
        return authorService.patchAuthor(authorId, author);
    }
    
}
