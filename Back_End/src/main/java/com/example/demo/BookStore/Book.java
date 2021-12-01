package com.example.demo.BookStore;

public class Book
{
    private String Name;
    private double Price;

    /**
     * Constructor for objects of class Book
     */
    public Book(String Name, double Price)
    {
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
