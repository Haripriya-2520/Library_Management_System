package com.example.Library_Management_System.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Category {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String name;


//    @ManyToMany(mappedBy="categories",cascade= CascadeType.ALL)
//    private List<Book> books;






}
