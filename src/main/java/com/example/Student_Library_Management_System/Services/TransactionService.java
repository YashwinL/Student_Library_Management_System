package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.DTOs.BookIssueDTO;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transactions;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import com.example.Student_Library_Management_System.Repositories.CardRepositories;
import com.example.Student_Library_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    CardRepositories cardRepositories;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public String TransactionEntry(BookIssueDTO bookIssueDTO) throws Exception{
        Transactions transactions = new Transactions();
        Book book = bookRepository.findById(bookIssueDTO.getBookid()).get();
        Card card = cardRepositories.findById(bookIssueDTO.getCardid()).get();

        transactions.setBook(book);
        transactions.setCard(card);
        transactions.setTransactionStatus(TransactionStatus.PENDING);
        transactions.setTransactionNo(UUID.randomUUID().toString());
        transactions.setFine(0);

        if(book==null || book.isIssued()){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Book is Already issued");
        }

        if(card==null || card.getCardStatus()!=CardStatus.ACTIVATED){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Card is not Active yet");
        }

        transactions.setTransactionStatus(TransactionStatus.SUCCESS);

        book.setCard(card);
        book.setIssued(true);
        List<Transactions> transactionsList = book.getTransactionsList();
        transactionsList.add(transactions);
        book.setTransactionsList(transactionsList);


        List<Transactions> transactionsListforcard = card.getTransactions();
        transactionsListforcard.add(transactions);
        card.setTransactions(transactionsListforcard);
        List<Book> bookswritten = card.getBookIsssued();
        bookswritten.add(book);
        card.setBookIsssued(bookswritten);

        cardRepositories.save(card);

        return "Book issued Successfully";
    }

    public String getTxnNobyBookandCardID(int bookid,int cardid){
        List<Transactions> transactionsList = transactionRepository.getTxnNobyBookandCardID(bookid,cardid);
        String transactionid = transactionsList.get(0).getTransactionNo();
        return transactionid;
    }
}
