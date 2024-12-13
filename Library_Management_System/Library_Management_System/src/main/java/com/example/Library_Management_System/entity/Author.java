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
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//
//    @ManyToMany(mappedBy="authors",cascade=CascadeType.ALL)
//    private List<Book> books;


}
