package com.nirmaan.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirmaan.project.entity.Transaction;
import com.nirmaan.project.service.TransactionService;

import apiresponse.ApiResponse;
import globalexcexception.ResourceNotFoundException;

@RestController
@RequestMapping("api/Transaction")
public class TransactionController {

	@Autowired
	public TransactionService transactionservice;

	@GetMapping("TransactionDetails")
	public ResponseEntity<ApiResponse<List<Transaction>>> getAll() {
		try {
			List<Transaction> transaction = transactionservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("found all", transaction, true));
		} catch (Exception e) {
			List<Transaction> transaction = transactionservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>(" not found ", transaction, false));

		}
	}

	@PostMapping
	public ResponseEntity<ApiResponse<Transaction>> createDetails(@RequestBody Transaction transaction) {
		Transaction transactiondata = transactionservice.createTransactionDetails(transaction);
		ApiResponse<Transaction> response = new ApiResponse<Transaction>("created Successfully", transactiondata, true);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<Transaction>>> getById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<Transaction> response = transactionservice.getExistingTransactionDetails(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("found by id", response, true));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<Transaction>>> deleteById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<Transaction> response = transactionservice.deleteDetails(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("deleted successfully", response, true));

	}

}
