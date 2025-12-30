package com.BankingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.BankingApp.entity.KycVerification;
import com.BankingApp.repositiory.KycVerificationRepo;


public class KycService {
	 @Autowired
     public KycVerificationRepo kycRepo;

     public KycVerification createKycDetails(KycVerification kyc) {
    	 
             return kycRepo.save(kyc);
             

     }

     public Optional<KycVerification> getExixtingKycDetails(Long id) {
 		return kycRepo.findById(id);
 	}
     

     public Optional<KycVerification> deleteDetails(long id, String name) {
             Optional<KycVerification> kyc = kycRepo.findById(id);
             kyc.ifPresent(e -> kycRepo.delete(e));
             return kyc;
     }

}
