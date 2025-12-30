package com.BankingApp.entity;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name ="Personal_details")
public class PersonalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personal_id;
	
	private String name;
	private int age;
	
	@Enumerated(EnumType.STRING)
	private String gender;
	
	private LocalDate DateOfBirth;
	private String mobilenumber;
	private String city;
	
	@Enumerated(EnumType.STRING)
	private String maritalstatus;
	
	private String nationality;
	private String fathername;
	private String mothername;
	
	@OneToMany
	@JsonManagedReference
	public Verification verification;
	
}
