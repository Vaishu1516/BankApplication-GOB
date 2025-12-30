package com.BankingApp.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankingApp.entity.Onboarding;

public interface OnboardingRepo extends JpaRepository<Onboarding, Long> {

}
