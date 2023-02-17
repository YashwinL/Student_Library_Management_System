package com.example.Student_Library_Management_System.DTOs;

public class BookIssueDTO {

    private int bookid;
    private int cardid;

    public BookIssueDTO() {
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }
}
