package com.example.Library_Management_System.controller;


import com.example.Library_Management_System.Service.AuthorService;
import com.example.Library_Management_System.Service.BookService;
import com.example.Library_Management_System.Service.CategoryService;
import com.example.Library_Management_System.Service.PublisherService;
import com.example.Library_Management_System.entity.Author;
import com.example.Library_Management_System.entity.Book;
import com.example.Library_Management_System.entity.Category;
import com.example.Library_Management_System.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;


    @GetMapping
    public ResponseEntity<List<Book>> listOfAuthors() {
        List<Book> books = bookService.getAllbooks();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeAuthor(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();

        }
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getAuthor(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateAuthor(@PathVariable int id, @RequestBody Book book) {
        Book exhistingBook = bookService.getBookById(id);
        if (exhistingBook == null) {
            return ResponseEntity.notFound().build();
        }
        List<Author> authors = new ArrayList<Author>();
        for (Author author : book.getAuthors()) {
            Author foundAuthor = authorService.getAuthorById(author.getId());
            if (foundAuthor == null) {
                return ResponseEntity.notFound().build();
            }
            authors.add(foundAuthor);
        }
        book.setAuthors(authors);


        //part-2 categories relationship

        List<Category> categories = new ArrayList<Category>();
        for (Category category : book.getCategories()) {
            Category foundCategory = categoryService.getCategoryById(category.getId());

            if (foundCategory == null) {
                return ResponseEntity.notFound().build();
            }
            categories.add(foundCategory);
        }
        book.setCategories(categories);

        //part 3 publisher relationship

        List<Publisher> publishers = new ArrayList<Publisher>();
        for (Publisher publisher : book.getPublisher()) {
            Publisher foundPublisher = publisherService.getPublisherById(publisher.getId());
            if (foundPublisher == null) {
                return ResponseEntity.notFound().build();
            }
            publishers.add(foundPublisher);

            book.setPublisher(publishers);

        }
            book.setId(id);
        bookService.saveOrUpdateBook(book);
        return ResponseEntity.ok(book);

    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        List<Author> authors = new ArrayList<Author>();
        for (Author author : book.getAuthors()) {
            Author foundAuthor = authorService.getAuthorById(author.getId());
            if (foundAuthor == null) {
                return ResponseEntity.notFound().build();
            }
            authors.add(foundAuthor);
        }
        book.setAuthors(authors);

        

        //part-2 categories relationship

        List<Category> categories = new ArrayList<Category>();
        for (Category category : book.getCategories()) {
            Category foundCategory = categoryService.getCategoryById(category.getId());

            if (foundCategory == null) {
                return ResponseEntity.notFound().build();
            }
            categories.add(foundCategory);
        }
        book.setCategories(categories);

        //part 3 publisher relationship

        List<Publisher> publishers = new ArrayList<Publisher>();
        for (Publisher publisher : book.getPublisher()) {
            Publisher foundPublisher = publisherService.getPublisherById(publisher.getId());
            if (foundPublisher == null) {
                return ResponseEntity.notFound().build();
            }
            publishers.add(foundPublisher);

            book.setPublisher(publishers);

        }
            Book createdBook = bookService.saveOrUpdateBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
        }


    }



