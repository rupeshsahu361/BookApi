package com.book.repository;

import com.book.entity.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, Integer> {

}
