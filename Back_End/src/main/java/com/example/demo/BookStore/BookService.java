package com.example.demo.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class BookService
{
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }



}
