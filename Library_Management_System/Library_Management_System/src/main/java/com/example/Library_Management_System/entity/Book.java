package com.example.Library_Management_System.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="books")

@Getter
@Setter
@NoArgsConstructor
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;


    @OneToMany
    @JoinTable(name="books_authors",
            joinColumns={@JoinColumn(name="book_id")},
    inverseJoinColumns={@JoinColumn(name="author_id")}
    )


    private List<Author> authors=new ArrayList<>();


    @OneToMany
    @JoinTable(name="books_categories",
            joinColumns={@JoinColumn(name="book_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<Category> categories=new ArrayList<>();

   @OneToMany
    @JoinTable(name="books_publishers",
            joinColumns={@JoinColumn(name="book_id")},
            inverseJoinColumns={@JoinColumn(name="publisher_id")}
    )
    private List<Publisher> publisher=new ArrayList<>();



}
