package com.example.demo.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping(value = "/api/v1/Book/search")
    public Book searchBook(@RequestParam(value = "bname", required = false) String bname){
        return bookService.searchBook(bname);
    }

    @RequestMapping(value = "/api/v1/Book", method = RequestMethod.GET)
    public List<Book> getBooks() {

        return bookService.getBooks();
    }

    @RequestMapping(value = "/api/v1/Book/{bnum}", method = RequestMethod.DELETE)
    public void removeBook(@PathVariable("bnum") int bnum){

        bookService.removeBook(bnum);
    }

    @RequestMapping(value = "/api/v1/Book", method = RequestMethod.POST)
    public void addBook(@RequestParam(value = "num", required = false) int num,
                        @RequestParam(value = "bname", required = false) String bname,
                        @RequestParam(value = "price", required = false) Double price){

        Book book = new Book(num, bname, price);
        bookService.addBook(book);
    }

}
