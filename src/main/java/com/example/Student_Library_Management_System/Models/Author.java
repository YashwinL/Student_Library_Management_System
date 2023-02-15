package com.example.Student_Library_Management_System.Models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    private String country;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> BooksWritten;

    public Author() {
        BooksWritten = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooksWritten() {
        return BooksWritten;
    }

    public void setBooksWritten(List<Book> booksWritten) {
        BooksWritten = booksWritten;
    }
}
