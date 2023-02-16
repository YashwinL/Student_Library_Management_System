package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositories extends JpaRepository<Student,Integer> {

    Student findByEmail(String name);


}
