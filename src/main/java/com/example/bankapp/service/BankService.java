package com.example.bankapp.service;

import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.Transaction;
import com.example.bankapp.repo.AccountRepo;
import com.example.bankapp.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    //Method to create new account
    public Account createAccount(String holderName, double initialBalance) {
        Account account = new Account(holderName, initialBalance);
        return accountRepo.save(account);
    }
    //Method to retrieve all accounts
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }
    //Method to deposit to an account
    public void deposit(Long accountId, double amount) {
        Account account = accountRepo.findById(accountId).orElseThrow(()-> new IllegalArgumentException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        accountRepo.save(account);

        Transaction transaction = new Transaction("Deposit", amount, Timestamp.valueOf(LocalDateTime.now()), account);
        transactionRepo.save(transaction);
    }
    //Method to withdraw from an account
    public void withdraw(Long accountId, double amount) {
        Account account = accountRepo.findById(accountId).orElseThrow(()-> new IllegalArgumentException("Account not found"));
        if(account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepo.save(account);

        Transaction transaction = new Transaction("Withdraw", amount, Timestamp.valueOf(LocalDateTime.now()), account);
        transactionRepo.save(transaction);
    }
    //Method to get transactions history
    public List<Transaction> getTransactionHistory(Long accountId, String type, Timestamp startDate, Timestamp endDate) {
        return transactionRepo.findByAccountId(accountId/*, type, startDate, endDate*/);
    }

    //Method to delete transaction by account id
    public void deleteAccount(Long accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(()-> new IllegalArgumentException("Account not found"));
        accountRepo.delete(account);
    }
}
