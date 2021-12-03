package com.example.demo.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
//@CrossOrigin("*")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping(value = "/api/v1/Book", method = RequestMethod.GET)
    public List<Book> getBooks() {

        return bookService.getBooks();
    }


    @RequestMapping(value = "/api/v1/Book", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")

    public void addBook(@RequestBody Book book) {
        System.out.println(book.getName());
        bookService.addBook(book);
    }

}
