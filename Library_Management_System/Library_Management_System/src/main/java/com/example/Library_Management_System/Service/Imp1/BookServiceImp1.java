package com.example.Library_Management_System.Service.Imp1;

import com.example.Library_Management_System.Service.BookService;
import com.example.Library_Management_System.repository.BookRepo;
import com.example.Library_Management_System.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp1 implements BookService {

@Autowired
    private BookRepo bookRepo;


    @Override
    public List<Book> getAllbooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is incorrect"));
    }

    @Override
    public Book saveOrUpdateBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBookById(int id) {

        bookRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is incorrect"));
        bookRepo.deleteById(id);

    }
}
