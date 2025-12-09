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
public class Support {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supportId;
	private boolean supportOpen;
	private boolean supportClose;
	private String review;
	
	
	@ManyToOne
	@JoinColumn(name="kyc_Id")
	@JsonBackReference
	private KycModel kycmodel;
	
	
	@ManyToOne
	@JoinColumn(name="infoId")
	@JsonBackReference
	private Info infoId;
	
	@ManyToOne
	@JoinColumn(name = "onBoard_Id")
	@JsonBackReference 
	private OnBoard onBoard;
	
	@ManyToOne
	@JoinColumn(name = "personal_id")
	@JsonBackReference
	private PersonalDetails personalId;
	
	

}
