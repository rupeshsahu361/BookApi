package com.book.service;

import com.book.entity.Genre;
import com.book.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    public Collection<Genre> getGenres() {
        return repository.findAll();
    }

    public Genre createGenre(Genre genre) {
        return repository.insert(genre);
    }


    public Optional<Genre> deleteGenreById(int id) {
        Optional<Genre> genre = repository.findById(id);
        genre.ifPresent(g -> repository.delete(g));
        return genre;
    }
}
