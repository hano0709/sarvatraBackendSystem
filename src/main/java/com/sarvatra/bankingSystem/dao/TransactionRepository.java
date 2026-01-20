package com.sarvatra.bankingSystem.dao;

import com.sarvatra.bankingSystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    
}
