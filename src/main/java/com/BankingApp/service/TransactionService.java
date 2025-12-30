package com.BankingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.BankingApp.entity.Transactions;
import com.BankingApp.repositiory.TransactionRepo;

import jakarta.transaction.Transaction;

public class TransactionService {
	 @Autowired
     public TransactionRepo transactionRepo;

     public Transactions createTransactionDetails(Transactions transaction) {
             return transactionRepo.save(transaction);
             
             

     }

     public Optional<Transactions> getExistingTransactionDetails(long id) {
             return transactionRepo.findById(id);
     }
     

     public Optional<Transactions> deleteDetails(long id, String name) {
             Optional<Transactions> transaction = transactionRepo.findById(id);
             transaction.ifPresent(e -> transactionRepo.delete(e));
             return transaction;
             
     }

      }


