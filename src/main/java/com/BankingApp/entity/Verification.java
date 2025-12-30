package com.BankingApp.entity;

import java.util.List;

import java.util.Optional;

import com.BankingApp.VerificationStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Verification")
public class Verification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Verification_Id;

	@Enumerated(EnumType.STRING)
	private String panNumber;

	@Enumerated(EnumType.STRING)
	private VerificationStatus aadharNumber;

	private String email;
	private String address;
	private boolean signature;

	@ManyToOne
	@JsonBackReference
	public Optional<List<PersonalDetails>> personlDetails;

}
