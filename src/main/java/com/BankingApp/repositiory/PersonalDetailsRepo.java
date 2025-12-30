package com.BankingApp.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApp.entity.PersonalDetails;

public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails, Long> {

}
