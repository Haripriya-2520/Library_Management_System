package com.example.Library_Management_System.repository;

import com.example.Library_Management_System.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
