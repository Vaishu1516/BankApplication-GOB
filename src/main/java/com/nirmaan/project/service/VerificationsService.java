package com.nirmaan.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.Verifications;
import com.nirmaan.project.repository.VerificationsRepo;

@Service
public class VerificationsService {

	@Autowired
	public VerificationsRepo verificationRepo;
	
	public List<Verifications> getAll()
	{
		return verificationRepo.findAll();
	}

	public Verifications create(Verifications verify) {
		return verificationRepo.save(verify);
	}

	public Optional<Verifications> getExistingVerifications(Long id) {
		return verificationRepo.findById(id);
	}

	public Optional<Verifications> deleteDetails(Long id) {
		Optional<Verifications> verify = verificationRepo.findById(id);
		verify.ifPresent(e -> verificationRepo.delete(e));
		return verify;
	}

}
