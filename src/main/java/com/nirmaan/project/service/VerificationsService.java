package com.nirmaan.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.Verifications;
import com.nirmaan.project.repository.VerificationsRepo;

@Service
public class VerificationsService {

	@Autowired
	public VerificationsRepo verificationRepo;

	public Verifications create(Verifications verify) {
		return verificationRepo.save(verify);
	}

	public Verifications getExistingVerifications(long id) {
		return verificationRepo.findById(id).get();
	}

	public Optional<Verifications> deleteDetails(long id, String name) {
		Optional<Verifications> verify = verificationRepo.findById(id);
		verify.ifPresent(e -> verificationRepo.delete(e));
		return verify;
	}

}
