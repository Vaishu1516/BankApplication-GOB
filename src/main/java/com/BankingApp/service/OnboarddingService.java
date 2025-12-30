package com.BankingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.BankingApp.entity.Onboarding;
import com.BankingApp.repositiory.OnboardingRepo;

public class OnboarddingService {
	  @Autowired
      public OnboardingRepo onBoardRepo;

      public Onboarding createOnboardDetails(Onboarding onboard) {
              return onBoardRepo.save(onboard);
      }

      public Onboarding getExistingOnBoardDetails(long id) {
              return onBoardRepo.findById(id).get();
      }

      public Optional<Onboarding> deleteDetails(long id, String name) {
              Optional<Onboarding> onBoard = onBoardRepo.findById(id);
              onBoard.ifPresent(e -> onBoardRepo.delete(e));
              return null;
      }

}
