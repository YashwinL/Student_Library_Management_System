package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    Date CreatedOn;

    @UpdateTimestamp
    Date UpdatedOn;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @OneToOne
    @JoinColumn
    private Student studentVariablename;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> bookIsssued;

    public void setStudentVariablename(Student student){
        this.studentVariablename = student;
    }

    public Card() {
        bookIsssued = new ArrayList<>();
    }

    public Card(int id, Date createdOn, Date updatedOn, CardStatus cardStatus) {
        this.id = id;
        CreatedOn = createdOn;
        UpdatedOn = updatedOn;
        this.cardStatus = cardStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(Date createdOn) {
        CreatedOn = createdOn;
    }

    public Date getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        UpdatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
