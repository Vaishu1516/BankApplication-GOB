package com.BankingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.BankingApp.entity.Verification;
import com.BankingApp.repositiory.VerificationRepo;

public class verificationService {
	@Autowired
    public VerificationRepo verificationRepo;

    public Verification create(Verification verify) {
            return verificationRepo.save(verify);
    }

    public Verification getExistingVerifications(long id) {
            return verificationRepo.findById(id).get();
    }

    public Optional<Verification> deleteDetails(long id, String name) {
            Optional<Verification> verify = verificationRepo.findById(id);
            verify.ifPresent(e -> verificationRepo.delete(e));
            return verify;
    }

}
