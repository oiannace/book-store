package com.example.demo.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1/Book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    public void add_book(){


    }
    @GetMapping
    public void getBooks() {

    }
}
