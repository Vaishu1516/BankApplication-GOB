package com.nirmaan.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.KycModel;
import com.nirmaan.project.repository.KycRepo;

@Service
public class KycService {

	@Autowired
	public KycRepo kycRepo;

	public KycModel createKycDetails(KycModel kyc) {
		return kycRepo.save(kyc);

	}

	public KycModel getExixtingKycDetails(long id) {
		return kycRepo.findById(id).get();
	}

	public Optional<KycModel> deleteDetails(long id, String name) {
		Optional<KycModel> kyc = kycRepo.findById(id);
		kyc.ifPresent(e -> kycRepo.delete(e));
		return kyc;
	}

}
