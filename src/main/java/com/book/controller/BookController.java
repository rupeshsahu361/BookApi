package com.book.controller;

import com.book.entity.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Collection<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(value = "/findById/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    @GetMapping(value = "/find")
    public Collection<Book> getBook(@RequestParam(name="authorId",required = false) Integer authorId,
                                    @RequestParam(name="genreId",required = false) Integer genreId){
        return bookService.getBook(authorId,genreId);
    }

    @PostMapping
    public Book postBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @DeleteMapping(value="/{id}")
    public Optional<Book> deleteBookById(@PathVariable("id") int id){
        return bookService.deleteBookById(id);
    }

    @PutMapping(value="/{id}")
    public Optional<Book> updateBookById(@PathVariable("id") int id,
                                         @RequestParam(name = "title", required = false) String title,
                                         @RequestParam(name = "year", required = false) Integer year,
                                         @RequestParam(name = "price", required = false) Integer price,
                                         @RequestParam(name = "authorId", required = false) Integer authorId,
                                         @RequestParam(name = "genreId", required = false) Integer genreId){
        return bookService.updateBookById(id, title, year, price, authorId, genreId);
    }


    @PutMapping(value="/addStockForBook/{id}")
    public void addStockForBook(@PathVariable("id") Integer bookId,
                                @RequestParam(name="stock",required = true) Integer stock){
        bookService.addStockForBook(bookId,stock);
    }

    @PutMapping(value="/sellBook")
    public String sellBook(@RequestParam(name = "bookId", required = true) Integer bookId){
        return bookService.sellBook(bookId);
    }
}
