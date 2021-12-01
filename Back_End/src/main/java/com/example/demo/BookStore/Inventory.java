package com.example.demo.BookStore;

import java.util.ArrayList;

public class Inventory
{
    private ArrayList<Book> Books;
    private static Inventory instance;

    public Inventory()
    {
        Books = new ArrayList<Book>();
    }

    public static Inventory getInstance()
    {
        if(instance == null){
            instance = new Inventory();
        }
        return instance;
    }

    public void addBook(String Name, double Price)
    {
        Books.add(new Book(Name, Price));
    }

    public void deleteBook(Book b)
    {
        for(int i = 0; i < Books.size(); i++){
            if(Books.get(i).getName().equals(b.getName())){
                Books.remove(i);
            }
        }
    }

    public ArrayList<Book> getBooks()
    {
        ArrayList<Book> tempBooks = new ArrayList<Book>();
        for(int i = 0; i < Books.size(); i++){
            tempBooks.add(Books.get(i));
        }
        return tempBooks;
    }

}
