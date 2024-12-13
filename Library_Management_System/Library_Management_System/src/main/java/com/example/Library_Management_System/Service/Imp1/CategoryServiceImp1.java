package com.example.Library_Management_System.Service.Imp1;

import com.example.Library_Management_System.Service.CategoryService;
import com.example.Library_Management_System.repository.CategoryRepo;
import com.example.Library_Management_System.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImp1 implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is incorrect"));
    }

    @Override
    public Category saveOrUpdateCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void deleteCategoryById(int id) {

       categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is incorrect"));
        categoryRepo.deleteById(id);

    }
}
