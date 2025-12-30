package com.BankingApp.entity;
import java.sql.Blob;
import java.util.List;
import com.BankingApp.AccountStatus;
import com.BankingApp.AccountType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Onboarding {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Onboarding_id;

	private long accountNumber;
	private String branch;
	private String ifsc;
	private String cif;
	private String bankName;
	private Blob photo;
	
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	@OneToMany(mappedBy = "onBoard" , cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Transactions> incomeTransactions;
	
	@OneToMany(mappedBy = "onBoard" , cascade = CascadeType.ALL)
	private List<Transactions> outcomeTransactions;

}
