package com.example.Student_Library_Management_System.Controller;

import com.example.Student_Library_Management_System.DTOs.StudMobNoUpdateDTO;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServices studentServices;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
       return studentServices.addStudent(student);
    }

    @GetMapping("/get_NameByEmail")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentServices.getNameByEmail(email);
    }

    @PutMapping("/update_mobno")
    public String update_mobno(@RequestBody StudMobNoUpdateDTO studMobNoUpdateDTO){
        return studentServices.update_mobno(studMobNoUpdateDTO);
    }
}
