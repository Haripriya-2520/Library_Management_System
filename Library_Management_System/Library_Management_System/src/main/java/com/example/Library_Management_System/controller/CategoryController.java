package com.example.Library_Management_System.controller;


import com.example.Library_Management_System.Service.CategoryService;
import com.example.Library_Management_System.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")



public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> listOfAuthors() {
        List<Category> categories= categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeCategory(@PathVariable int id){
        Category category=categoryService.getCategoryById(id);
        if(category==null) {
            return ResponseEntity.notFound().build();

        }
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id){
       Category category=categoryService.getCategoryById(id);
        if(category==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(category);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category){
        Category exhistingCategory=categoryService.getCategoryById(id);
        if(exhistingCategory==null){
            return ResponseEntity.notFound().build();
        }
        category.setId(id);
        categoryService.saveOrUpdateCategory(category);
        return ResponseEntity.ok(category);

    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category createdcategory=categoryService.saveOrUpdateCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdcategory);
    }






}
