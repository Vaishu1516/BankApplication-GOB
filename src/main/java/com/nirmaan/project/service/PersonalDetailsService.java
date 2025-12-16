package com.nirmaan.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.PersonalDetails;
import com.nirmaan.project.repository.PersonalDetailsRepo;

@Service
public class PersonalDetailsService {

	@Autowired
	public PersonalDetailsRepo personalRepo;

	public PersonalDetails createDetails(PersonalDetails pd) {

		return personalRepo.save(pd);
	}

	public PersonalDetails getExistingDetails(long id) {
		return personalRepo.findById(id).get();
	}

	public PersonalDetails updateDetails(long id, PersonalDetails newdata) {
		PersonalDetails olddata = getExistingDetails(id);
		olddata.setVerifications(newdata.getVerifications());
		return personalRepo.save(olddata);
	}

	public Optional<PersonalDetails> deleteDetails(long id, String name) {
		Optional<PersonalDetails> pd = personalRepo.findById(id);
		pd.ifPresent(e -> personalRepo.delete(e));
		return pd;

	}

}
