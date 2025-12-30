package com.nirmaan.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.PersonalDetails;
import com.nirmaan.project.repository.PersonalDetailsRepo;

@Service
public class PersonalDetailsService {

	@Autowired
	public PersonalDetailsRepo personalRepo;
	
	public List<PersonalDetails> getAll()
	{
		return personalRepo.findAll();
				}

	public PersonalDetails createDetails(PersonalDetails pd) {

		return personalRepo.save(pd);
	}

	public Optional<PersonalDetails> getExistingDetails(long id) {
		return personalRepo.findById(id);
	}

	

	public Optional<PersonalDetails> deleteDetails(long id) {
		Optional<PersonalDetails> pd = personalRepo.findById(id);
		pd.ifPresent(e -> personalRepo.delete(e));
		return pd;

	}

}
