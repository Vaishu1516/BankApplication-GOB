package com.BankingApp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Info {
	
	private Long info_id;
	
	@OneToOne
	@JsonManagedReference
	@JoinColumn(name = " onboarding_id")
	public Onboarding onboard;
	
	public PersonalDetails person_details;

}
