package com.nirmaan.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.Info;
import com.nirmaan.project.repository.InfoRepo;

@Service
public class InfoService {

	@Autowired
	public InfoRepo infoRepo;
	
	public List<Info> getAll()
	{
		
		return infoRepo.findAll();
	}

	public Info createInfoDetails(Info info) {
		return infoRepo.save(info);
	}

	public Optional<Info> getExistingDetails(long id) {
		return infoRepo.findById(id);
	}

	public Optional<Info> deleteDetails(long id) {
		Optional<Info> info = infoRepo.findById(id);
		info.ifPresent(e -> infoRepo.delete(e));
		return info;
	}

}
