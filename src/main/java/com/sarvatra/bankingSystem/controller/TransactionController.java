package com.sarvatra.bankingSystem.controller;

import com.sarvatra.bankingSystem.dao.TransactionRepository;
import com.sarvatra.bankingSystem.entity.Transaction;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return transactionRepository.save(transaction);
    }
}