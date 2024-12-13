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
@Table(name="publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

//    @ManyToMany(mappedBy="publisher",cascade=CascadeType.ALL)
//    private List<Book> books;
}
