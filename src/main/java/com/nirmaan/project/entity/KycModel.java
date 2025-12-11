package com.nirmaan.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class KycModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long kyc_Id;

	@ManyToOne
	@JsonBackReference
	public Verifications kyc_Verifications;

	@Enumerated(EnumType.STRING)
	private KycModel kyc_Status;
}
