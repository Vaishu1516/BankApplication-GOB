package com.nirmaan.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.KycModel;
import com.nirmaan.project.repository.KycRepo;

@Service
public class KycService {

	@Autowired
	public KycRepo kycRepo;

	public List<KycModel> getAll()
	{
		return kycRepo.findAll();
	}
	
	public KycModel createKycDetails(KycModel kyc) {
		return kycRepo.save(kyc);

	}

	public Optional<KycModel> getExixtingKycDetails(Long id) {
		return kycRepo.findById(id);
	}

	public Optional<KycModel> deleteDetails(Long id) {
		Optional<KycModel> kyc = kycRepo.findById(id);
		kyc.ifPresent(e -> kycRepo.delete(e));
		return kyc;
	}

}
