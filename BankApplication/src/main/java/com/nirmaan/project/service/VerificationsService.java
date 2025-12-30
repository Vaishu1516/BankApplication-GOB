package com.nirmaan.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.repository.VerificationsRepo;

@Service
public class VerificationsService {
	
	@Autowired
	public VerificationsRepo verificationRepo;

}
