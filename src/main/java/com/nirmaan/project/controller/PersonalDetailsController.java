package com.nirmaan.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nirmaan.project.entity.PersonalDetails;
import com.nirmaan.project.service.PersonalDetailsService;

import apiresponse.ApiResponse;
import globalexcexception.ResourceNotFoundException;

@RestController
@RequestMapping("Personal_Details")
public class PersonalDetailsController {

	@Autowired
	public PersonalDetailsService personalservice;

	@GetMapping("PersonalDetails")
	public ResponseEntity<ApiResponse<List<PersonalDetails>>> getAll() {
		try {
			List<PersonalDetails> personaldata = personalservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("found all", personaldata, true));
		} catch (Exception e) {
			List<PersonalDetails> personaldata = personalservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("not found", personaldata, false));
		}
	}

	@PostMapping
	public ResponseEntity<ApiResponse<PersonalDetails>> createDetails(@RequestBody PersonalDetails personaldata) {
		PersonalDetails personal = personalservice.createDetails(personaldata);
		ApiResponse<PersonalDetails> response = new ApiResponse<PersonalDetails>("created successfully", personal,
				true);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<PersonalDetails>>> getById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<PersonalDetails> response = personalservice.getExistingDetails(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("found by id", response, true));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<PersonalDetails>>> deleteById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<PersonalDetails> response = personalservice.deleteDetails(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("deleted successfully", response, true));
	}

}
