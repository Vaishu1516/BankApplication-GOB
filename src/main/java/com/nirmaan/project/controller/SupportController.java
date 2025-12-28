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

import com.nirmaan.project.entity.Support;
import com.nirmaan.project.service.SupportService;

import apiresponse.ApiResponse;
import globalexcexception.ResourceNotFoundException;

@RestController
@RequestMapping("api/support/")
public class SupportController {

	@Autowired
	public SupportService supportservice;

	@GetMapping("Support_Details")
	public ResponseEntity<ApiResponse<List<Support>>> getAll() {
		try {
			List<Support> support = supportservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("found all", support, true));
		} catch (Exception e) {
			List<Support> support = supportservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>(" not found", support, false));
		}
	}

	@PostMapping
	public ResponseEntity<ApiResponse<Support>> createDetails(@RequestBody Support support) {
		Support supportdata = supportservice.createSupportDetails(support);
		ApiResponse<Support> response = new ApiResponse<Support>("created successfully", supportdata, true);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<Support>>> getById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<Support> response = supportservice.getExistingDetails(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("found by id", response, true));

	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<Support>>> deleteById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<Support> response = supportservice.deleteDetails(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("deleted successfully", response, false));
	}

}
