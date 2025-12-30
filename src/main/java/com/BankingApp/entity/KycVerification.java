package com.BankingApp.entity;

import com.BankingApp.Kyc;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class KycVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long KycVerification_id;

	@OneToMany
	@JsonManagedReference
	@JoinColumn(name = "Verification_id")
	public Verification kyc_Verification;

	@Enumerated(EnumType.STRING)
	public Kyc kyc_Status;

}
