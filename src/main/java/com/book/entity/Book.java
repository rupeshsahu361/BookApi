package com.book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private Integer bookId;
    private String title;
    private Integer year;
    private Integer price;
    private Integer authorId;
    private Integer genreId;
    private Integer stock;

}
