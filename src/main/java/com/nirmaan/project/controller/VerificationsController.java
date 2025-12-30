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

import com.nirmaan.project.entity.Verifications;
import com.nirmaan.project.service.VerificationsService;

import apiresponse.ApiResponse;
import globalexcexception.ResourceNotFoundException;

@RestController
@RequestMapping("api/Verifications")
public class VerificationsController {

	@Autowired
	public VerificationsService verifyservice;

	@GetMapping("Verification_details")
	public ResponseEntity<ApiResponse<List<Verifications>>> getAll() {
		try {
			List<Verifications> verify = verifyservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("found all", verify, true));
		} catch (Exception e) {

			List<Verifications> verify = verifyservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>(" not found ", verify, false));

		}
	}

	@PostMapping
	public ResponseEntity<ApiResponse<Verifications>> createDetails(@RequestBody Verifications verify) {
		Verifications verifydata = verifyservice.create(verify);
		ApiResponse<Verifications> response = new ApiResponse<Verifications>("created successfully", verifydata, true);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<Verifications>>> getById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<Verifications> response = verifyservice.getExistingVerifications(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("found by id", response, true));

	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<Verifications>>> deleteById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<Verifications> response = verifyservice.deleteDetails(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("deleted successfully", response, true));
	}
}
