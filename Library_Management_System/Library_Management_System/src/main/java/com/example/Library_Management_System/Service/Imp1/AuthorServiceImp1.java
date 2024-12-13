package com.example.Library_Management_System.Service.Imp1;

import com.example.Library_Management_System.Service.AuthorService;
import com.example.Library_Management_System.repository.AuthorRepo;
import com.example.Library_Management_System.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorServiceImp1 implements AuthorService {

@Autowired
    private AuthorRepo authorRepo;


    @Override
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is incorrect"));
    }

    @Override
    public Author saveOrUpdateAuthor(Author author) {
        return authorRepo.save(author);

    }

    @Override
    public void deleteAuthorById(int id) {
        authorRepo.findById(id).orElse(null);
        authorRepo.deleteById(id);
    }
}
