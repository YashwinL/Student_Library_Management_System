package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    @Autowired
    StudentRepositories studentRepositories;

    public String addStudent(Student student){

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariablename(student);

        student.setCard(card);

        studentRepositories.save(student);

        return "Both Student and Card has been Created Successfully";
    }

    public String getNameByEmail(String email)  {
        Student student = studentRepositories.findByEmail(email);
        return student.getName();
    }

    public String update_mobno(Student student){
        Student student1 = studentRepositories.findById(student.getId()).get();
        student1.setMobno(student.getMobno());
        studentRepositories.save(student1);
        return "Student mobile-no changed successfully";
    }


}
