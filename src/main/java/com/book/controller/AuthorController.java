package com.book.controller;

import com.book.entity.Author;
import com.book.entity.Book;
import com.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public Collection<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping
    public Author postBook(@RequestBody Author author){
        return authorService.createBook(author);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Author> deleteAuthorById(@PathVariable("id") int id){
        return authorService.deleteAuthorById(id);
    }

}
