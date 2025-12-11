package com.nirmaan.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.repository.PersonalDetailsRepo;

@Service
public class PersonalDetailsService {
	
	@Autowired
	public PersonalDetailsRepo personalRepo;

}
