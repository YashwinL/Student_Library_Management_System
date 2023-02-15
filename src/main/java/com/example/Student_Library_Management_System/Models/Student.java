package com.example.Student_Library_Management_System.Models;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private int MobileNo;

    private String country;

    @OneToOne(mappedBy = "studentVariablename", cascade =CascadeType.ALL)
    private Card card;

    public void setCard(Card card){
        this.card = card;
    }

    public Student() {
    }

    public Student(int id, String name, String email, int mobileNo, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        MobileNo = mobileNo;
        this.country = country;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(int mobileNo) {
        MobileNo = mobileNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
