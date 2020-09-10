package com.book.service;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Collection<Book> getBooks(){
        return repository.findAll();
    }

    public Book createBook(Book book) {
        return repository.insert(book);
    }

    public Optional<Book> getBookById(int id) {
        return repository.findById(id);
    }

    public Collection<Book> getBook(Integer authorId, Integer genreId) {
        Collection<Book> book = new ArrayList<>();
        if(Objects.isNull(authorId) && Objects.nonNull(genreId))
            return repository.findByGenreId(genreId);
        else if(Objects.nonNull(authorId) && Objects.isNull(genreId))
            return  repository.findByAuthorId(authorId);
        else if(Objects.nonNull(authorId) && Objects.nonNull(genreId))
            return  repository.findByAuthorIdAndGenreId(authorId,genreId);
        return book;
    }

    public Optional<Book> deleteBookById(int id){
        Optional<Book> book = repository.findById(id);
        book.ifPresent(b -> repository.delete(b));
        return book;
    }

    public Optional<Book> updateBookById(int id, String title, Integer year, Integer price, Integer authorId, Integer genreId) {
        Optional<Book> book = repository.findById(id);
        book.ifPresent(b -> {if(Objects.nonNull(title))b.setTitle(title);});
        book.ifPresent(b -> {if(Objects.nonNull(year))b.setYear(year);});
        book.ifPresent(b -> {if(Objects.nonNull(price))b.setPrice(price);});
        book.ifPresent(b -> {if(Objects.nonNull(authorId))b.setAuthorId(authorId);});
        book.ifPresent(b -> {if(Objects.nonNull(genreId))b.setGenreId(genreId);});
        book.ifPresent(b -> repository.save(b));
        return book;
    }

    public void addStockForBook(Integer bookId, Integer stock) {
        Optional<Book> book = repository.findById(bookId);
        book.ifPresent(b -> b.setStock(b.getStock()+stock));
        book.ifPresent(b -> repository.save(b));
    }

    public String sellBook(Integer bookId) {
        Optional<Book> book = repository.findById(bookId);
        if(Objects.isNull(book))
            return ("Book Not found!!!");
        final String[] s = new String[1];
        book.ifPresent(b -> {
            if(b.getStock()==0) {
                s[0] = "Book Out of Stock!!!";
            } else{
                b.setStock(b.getStock()-1);
                repository.save(b);
                s[0] = "Success!!!";
            }
        });
        return s[0];
    }
}
