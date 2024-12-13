package com.example.Library_Management_System.repository;

import com.example.Library_Management_System.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
