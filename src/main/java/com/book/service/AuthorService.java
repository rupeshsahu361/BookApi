package com.book.service;

import com.book.entity.Author;
import com.book.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public Collection<Author> getAuthors() {
        return repository.findAll();
    }

    public Author createBook(Author author) {
        return repository.insert(author);
    }

    public Optional<Author> deleteAuthorById(int id) {
        Optional<Author> author = repository.findById(id);
        author.ifPresent(a -> repository.delete(a));
        return author;
    }
}
