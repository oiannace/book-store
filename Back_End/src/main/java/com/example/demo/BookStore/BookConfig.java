package com.example.demo.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repo){
        return args->{
            Book Book1 = new Book (1,"The Hobbit", 9.99);
            Book Book2 = new Book (2,"Harry Potter and the Philosophers Stone", 12.99);
            ArrayList<Book> Books = new ArrayList<Book>();
            Books.add(Book1);
            Books.add(Book2);
            repo.saveAll(
                    Books
            );
        };
    }
}
