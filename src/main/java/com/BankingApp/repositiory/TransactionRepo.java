package com.BankingApp.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApp.entity.Transactions;

public interface TransactionRepo extends JpaRepository<Transactions, Long> {

}
