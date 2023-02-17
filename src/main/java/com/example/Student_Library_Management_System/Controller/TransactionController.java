package com.example.Student_Library_Management_System.Controller;


import com.example.Student_Library_Management_System.DTOs.BookIssueDTO;
import com.example.Student_Library_Management_System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/BookTransaction")
    public String TransactionEntry(@RequestBody  BookIssueDTO bookIssueDTO) throws Exception {
        return transactionService.TransactionEntry(bookIssueDTO);
    }

    @GetMapping("/getTxnNobyBookandCardID")
    public String getTxnNobyBookandCardID(@RequestParam("bookid") int bookid,@RequestParam("cardid") int cardid){
        return transactionService.getTxnNobyBookandCardID(bookid,cardid);
    }
}
