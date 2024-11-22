package com.example.bankapp.controller;

import com.example.bankapp.entity.Transaction;
import org.springframework.ui.Model;
import com.example.bankapp.entity.Account;
import com.example.bankapp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BankController {

    @Autowired
    private BankService bankService;

    //Display list of all accounts
    @GetMapping("/")
    public String viewAllAccounts(Model model) {
       List<Account> accountsList = bankService.getAllAccounts();
       model.addAttribute("accounts", accountsList);

       return "Accounts";
    }

    //Add a new account
    @PostMapping("/accounts/add")
    public String createAccount(@RequestParam String holderName, @RequestParam double initialBalance) {
        bankService.createAccount(holderName, initialBalance);

        return "redirect:/";
    }

    //Deposit to an account
    @PostMapping("/{id}/deposit")
    public String deposit(@PathVariable("id") Long accountId, @RequestParam("amount") double amount) {
        bankService.deposit(accountId, amount);

        return "redirect:/";
    }

    //Withdraw from an account
    @PostMapping("/{id}/withdraw")
    public String withdraw(@PathVariable("id") Long accountId, @RequestParam("amount") double amount) {
        bankService.withdraw(accountId, amount);

        return "redirect:/";
    }
    //View transaction history
    @GetMapping("/{id}/transactions")
    public String viewTransactions(@PathVariable("id") Long accountId, @RequestParam(required = false) String type, @RequestParam(required = false) Timestamp startDate, @RequestParam(required = false) Timestamp endDate, Model model) {

        List<Transaction> transaction = bankService.getTransactionHistory(accountId, type, startDate, endDate);
        model.addAttribute("transactions", transaction);
        model.addAttribute("accountId", accountId);

        return "Transactions";
    }

    @PostMapping("/accounts/delete/{accountId}")
    public String deleteAccount(@PathVariable("accountId") Long accountId) {
        bankService.deleteAccount(accountId);
        return "redirect:/";
    }
}
