package com.nirmaan.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.Transaction;
import com.nirmaan.project.repository.TransactionRepo;

@Service
public class TransactionService {
	@Autowired
	public TransactionRepo transactionRepo;
	
	public List<Transaction> getAll()
	{
		return transactionRepo.findAll();
	}

	public Transaction createTransactionDetails(Transaction transaction) {
		return transactionRepo.save(transaction);

	}

	public Optional<Transaction> getExistingTransactionDetails(long id) {
		return transactionRepo.findById(id);
	}

	public Optional<Transaction> deleteDetails(long id) {
		Optional<Transaction> transaction = transactionRepo.findById(id);
		transaction.ifPresent(e -> transactionRepo.delete(e));
		return transaction;
	}

}
