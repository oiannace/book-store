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
    private int num;
    private String bname;
    private double price;

    /**
     * Constructor for objects of class Book
     */
    public Book(){}
    public Book(int num, String bname, double price)
    {
        this.num = num;
        this.bname = bname;
        this.price = price;
    }
    public String getName()
    {
        return bname;
    }
    public double getPrice()
    {
        return price;
    }
    public int getNum() {return num;}
}
