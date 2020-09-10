package com.book.repository;

import com.book.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface BookRepository extends MongoRepository<Book, Integer> {
    

    Collection<Book> findByAuthorIdAndGenreId(Integer authorId, Integer genreId);

    Collection<Book> findByGenreId(Integer genreId);

    Collection<Book> findByAuthorId(Integer genreId);
}
