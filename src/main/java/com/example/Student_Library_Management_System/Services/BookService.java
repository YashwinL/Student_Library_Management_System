package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String add_book(Book book){
        int authorid = book.getAuthor().getId();

        Author author = authorRepository.findById(authorid).get();

        book.setAuthor(author);

        List<Book> bookswritten = author.getBooksWritten();
        bookswritten.add(book);
        author.setBooksWritten(bookswritten);

        authorRepository.save(author);

        return "Book Added Successfully";
    }
}
