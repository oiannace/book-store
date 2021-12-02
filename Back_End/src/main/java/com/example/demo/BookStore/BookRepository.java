package com.example.demo.BookStore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {

    @Query("SELECT b FROM Book b WHERE b.id = ?1")
    Optional<Book> findBookById(int id);
}
