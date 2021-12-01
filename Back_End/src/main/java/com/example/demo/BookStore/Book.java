package com.example.demo.BookStore;

import javax.persistence.*;

@Entity
@Table
public class Book
{
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private int id;
    private String Name;
    private double Price;

    /**
     * Constructor for objects of class Book
     */
    public Book(){}
    public Book(int id, String Name, double Price)
    {
        this.id = id;
        this.Name = Name;
        this.Price = Price;
    }
    public String getName()
    {
        return Name;
    }
    public double getPrice()
    {
        return Price;
    }
}
