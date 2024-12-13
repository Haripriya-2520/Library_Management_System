package com.example.Library_Management_System.controller;


import com.example.Library_Management_System.Service.AuthorService;
import com.example.Library_Management_System.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {


    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> listOfAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

@DeleteMapping("/{id}")
        public ResponseEntity<String> removeAuthor(@PathVariable int id){
        Author author=authorService.getAuthorById(id);
        if(author==null) {
            return ResponseEntity.notFound().build();

        }
            authorService.deleteAuthorById(id);
            return ResponseEntity.noContent().build();

        }
        @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable int id){
        Author author=authorService.getAuthorById(id);
        if(author==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable int id,@RequestBody Author author){
        Author exhistingAuthor=authorService.getAuthorById(id);
        if(exhistingAuthor==null){
            return ResponseEntity.notFound().build();
        }
        author.setId(id);
        authorService.saveOrUpdateAuthor(author);
        return ResponseEntity.ok(author);

    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        Author createdAuthor=authorService.saveOrUpdateAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

}
