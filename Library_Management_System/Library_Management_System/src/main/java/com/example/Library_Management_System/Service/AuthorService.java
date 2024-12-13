package com.example.Library_Management_System.Service;

import com.example.Library_Management_System.entity.Author;

import java.util.List;

public interface AuthorService {


    //get all
    List<Author> getAllAuthors();
    //get by id
    public Author getAuthorById(int id);

       //save authors
    public Author saveOrUpdateAuthor(Author author);


    //delete by id
    public void deleteAuthorById(int id);


}
