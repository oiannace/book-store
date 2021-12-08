package com.example.demo.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public void removeBook(int num){
        boolean bnum = bookRepository.existsById(num);
        if(!bnum){
            throw new IllegalStateException("Book with id "+ num + " does not exist");
        }
        bookRepository.deleteById(num);
    }

    public void addBook(Book book){
        Optional<Book> bookOptional = bookRepository.findBookByName(book.getName());
        if(bookOptional.isPresent()){
            throw new IllegalStateException("Name already exists.");
        }
        bookRepository.save(book);
    }

    public Book searchBook(String bname) {
        Optional<Book> bookOptional = bookRepository.findBookByName(bname);
        if(!bookOptional.isPresent()){
            throw new IllegalStateException("Book does not exist.");
        }
        Book book = bookOptional.get();
        return book;
    }
}
