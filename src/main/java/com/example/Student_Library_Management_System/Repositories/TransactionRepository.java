package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {

    @Query(value = "select * from transaction t where t.book_id=:bookid and t.card_id=:cardid",nativeQuery = true)
    List<Transactions> getTxnNobyBookandCardID(int bookid, int cardid);
}
