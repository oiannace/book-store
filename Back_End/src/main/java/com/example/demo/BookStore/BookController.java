package com.example.demo.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1/Book")
public class BookController {
    private Inventory inv = Inventory.getInstance();


    public void add_book(){
        inv.addBook("The Hobbit", 9.99);
        inv.addBook("Eragon", 11.99);

    }
    @GetMapping
    public ArrayList<Book> getBooks() {
        return inv.getBooks();
    }
}
