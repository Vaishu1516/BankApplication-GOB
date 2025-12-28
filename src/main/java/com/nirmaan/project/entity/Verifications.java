package com.nirmaan.project.entity;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nirmaan.project.VerificationStatus;

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
public class Verifications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long verifications_Id;

	@Enumerated(EnumType.STRING)
	private VerificationStatus aadharNumber;

	@Enumerated(EnumType.STRING)
	private VerificationStatus panNumber;

	private boolean signature;

	private String email;

	@ManyToOne
	@JoinColumn(name = "personalId")
	@JsonBackReference
	public PersonalDetails personal_Details;
}
