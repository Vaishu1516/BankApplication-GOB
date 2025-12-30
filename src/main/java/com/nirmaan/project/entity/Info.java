package com.nirmaan.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Info {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long infoId;

	@ManyToOne
	@JoinColumn(name = "onBoard_Id")
	@JsonBackReference
	private OnBoard onBoard;

	@ManyToOne
	@JoinColumn(name = "kyc_Id")
	@JsonBackReference
	private KycModel kycmodel;

	@ManyToOne
	@JoinColumn(name = "kyc_Status")
	@JsonBackReference
	private KycModel kycStatus;

	@ManyToOne
	@JoinColumn(name = "kyc_Verifications")
	@JsonBackReference
	private KycModel kycVerification;

	@ManyToOne
	@JoinColumn(name = "supportId")
	@JsonBackReference
	private Support supportId;

	@ManyToOne
	@JoinColumn(name = "review")
	@JsonBackReference
	private Support supportReview;

}
