package com.BankingApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Support {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long support_id;
	
	
	private boolean support_close;
	
	private boolean support_open;
	
	private String support_review;
	
	@ManyToOne
	@JoinColumn(name = "Onboarding_id")
	private Onboarding onBoard;
	
	@OneToOne
	@JoinColumn(name = "personal_id")
	public PersonalDetails persons_details;
	
	
	public Info info_details;

}
