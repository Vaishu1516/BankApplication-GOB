package com.BankingApp.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApp.entity.Verification;

public interface VerificationRepo extends JpaRepository<Verification, Long> {
	
	

}
