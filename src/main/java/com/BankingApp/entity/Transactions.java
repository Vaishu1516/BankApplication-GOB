package com.BankingApp.entity;

import java.time.LocalDateTime;

import com.BankingApp.Kyc;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Transaction_Id;
	

	@ManyToOne
	@JsonBackReference
	private Onboarding onBoard;
	
	@Enumerated(EnumType.STRING)
	private Kyc kysVerification;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "kyc_id")
	private Onboarding history;
	
	private double income;
	private double outcome;
	private double balance;
	
	private LocalDateTime timeStamp;
	private String mini_Statement;

}
