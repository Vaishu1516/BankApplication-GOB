package com.nirmaan.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.Transaction;
import com.nirmaan.project.repository.TransactionRepo;

@Service
public class TransactionService {
	@Autowired
	public TransactionRepo transactionRepo;

	public Transaction createTransactionDetails(Transaction transaction) {
		return transactionRepo.save(transaction);

	}

	public Transaction getExistingTransactionDetails(long id) {
		return transactionRepo.findById(id).get();
	}

	public Optional<Transaction> deleteDetails(long id, String name) {
		Optional<Transaction> transaction = transactionRepo.findById(id);
		transaction.ifPresent(e -> transactionRepo.delete(e));
		return transaction;
	}

}
