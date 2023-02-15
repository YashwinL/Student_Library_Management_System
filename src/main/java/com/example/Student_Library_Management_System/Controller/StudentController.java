package com.example.Student_Library_Management_System.Controller;

import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    StudentServices studentServices;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
       return studentServices.addStudent(student);
    }
}
