package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.DTOs.AddBookDTO;
import com.example.Student_Library_Management_System.Enums.Genre;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String add_book(AddBookDTO addBookDTO){
       Book book = new Book();
        Author author = authorRepository.findById(addBookDTO.getAuthorid()).get();
       book.setName(addBookDTO.getName());
       book.setPages(addBookDTO.getPages());
       book.setIssued(false);
       book.setGenre(Genre.valueOf(addBookDTO.getGenre()));
       book.setAuthor(author);
       List<Book> writtenbooks = author.getBooksWritten();
       writtenbooks.add(book);
       authorRepository.save(author);
        return "Book Added Successfully";
    }
}
