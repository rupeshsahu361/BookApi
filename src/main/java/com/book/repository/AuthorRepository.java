package com.book.repository;

import com.book.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, Integer> {


}
