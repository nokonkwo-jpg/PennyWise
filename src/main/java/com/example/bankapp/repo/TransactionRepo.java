package com.example.bankapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankapp.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.account.id = :accountId")
    List<Transaction> findByAccountId(@Param("accountId") Long accountId);



}