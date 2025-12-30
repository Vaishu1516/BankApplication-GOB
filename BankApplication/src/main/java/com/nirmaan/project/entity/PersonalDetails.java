package com.nirmaan.project.entity;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class PersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToMany
	private int personal_id;

	private String userName;
	private int mobileNumber;
	private LocalDate dob;
	private int age;
	private String gender;
	private String address;
	private String nationality;
	private String fatherName;
	private String motherName;

	@OneToMany
	@JsonManagedReference
	public List<Verifications> verifications;
	
	
	
}
