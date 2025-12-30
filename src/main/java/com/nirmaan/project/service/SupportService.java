package com.nirmaan.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.Support;
import com.nirmaan.project.repository.SupportRepo;

@Service
public class SupportService {
	@Autowired
	public SupportRepo supportRepo;
	
	public List<Support> getAll()
	{
		return supportRepo.findAll();
	}

	public Support createSupportDetails(Support support) {
		return supportRepo.save(support);

	}

	public Optional<Support> getExistingDetails(long id) {
		return supportRepo.findById(id);
	}

	public Optional<Support> deleteDetails(long id) {
		Optional<Support> support = supportRepo.findById(id);
		support.ifPresent(e -> supportRepo.delete(e));
		return support;
	}

}
