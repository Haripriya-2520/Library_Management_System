package com.example.Library_Management_System.Service;

import com.example.Library_Management_System.entity.Category;

import java.util.List;

public interface CategoryService {


    //GET all categories
    public List<Category> getAllCategories();

    //Get category By id
    public Category getCategoryById(int id);

    //Save Category details
    public Category saveOrUpdateCategory(Category category);

    //delete by id
    public void deleteCategoryById(int id);
}
