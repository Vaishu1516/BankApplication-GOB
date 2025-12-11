package com.nirmaan.project.entity;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nirmaan.project.Kyc;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transaction_id;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "kyc_Id")
	private Kyc kycVerifications;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "onBoard_Id")
	private OnBoard history;

	private long income_Transactions;
	private long Outgoing_Transactions;
	private long account_Balance;
	private LocalDateTime timeStamp;
	private String mini_Statement;

}
