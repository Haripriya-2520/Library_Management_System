package com.example.Library_Management_System.Service;

import com.example.Library_Management_System.entity.Book;

import java.util.List;

public interface BookService {

    //GET all books
    public List<Book> getAllbooks();

    //Get book By id
    public Book getBookById(int id);

    //Save Book details
    public Book saveOrUpdateBook(Book book);

    //delete by id
    public void deleteBookById(int id);
}
