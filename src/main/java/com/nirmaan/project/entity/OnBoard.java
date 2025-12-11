package com.nirmaan.project.entity;

import java.time.LocalDateTime;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nirmaan.project.AccountStatus;
import com.nirmaan.project.AccountType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class OnBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToMany
	private long onBoard_Id;
	
	private long accountNumber;
	private String bankName;
	private String branchName;
	private LocalDateTime accountCreatedAt;//

	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;//

	private String IFSC;
	private long CIF;

	@ManyToOne
	@JsonBackReference
	public PersonalDetails personal_Details;

	@OneToMany(mappedBy = "accountDetails", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Transaction> transactions;

	private long outGoingTransaction;//
	private long incomingTransaction;//

}
