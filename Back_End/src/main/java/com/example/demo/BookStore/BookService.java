package com.example.demo.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){
        Optional<Book> bookOptional = bookRepository.findBookById(book.getId());
        if(bookOptional.isPresent()){
            throw new IllegalStateException("Name already exists.");
        }
        bookRepository.save(book);
    }
}
