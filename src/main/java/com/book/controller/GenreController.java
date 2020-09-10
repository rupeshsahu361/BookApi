package com.book.controller;

import com.book.entity.Genre;
import com.book.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public Collection<Genre> getGenres(){
        return genreService.getGenres();
    }

    @PostMapping
    public Genre postGenre(@RequestBody Genre genre){
        return genreService.createGenre(genre);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Genre> deleteGenreById(@PathVariable("id") int id){
        return genreService.deleteGenreById(id);
    }
}
