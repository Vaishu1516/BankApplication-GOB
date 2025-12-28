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

import com.nirmaan.project.entity.KycModel;
import com.nirmaan.project.service.KycService;

import apiresponse.ApiResponse;
import globalexcexception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/Kyc/")
public class KycController {

	@Autowired
	public KycService kycservice;

	@GetMapping("kycDetails")
	public ResponseEntity<ApiResponse<List<KycModel>>> getAll() {
		try {
			List<KycModel> kyc = kycservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("found all", kyc, true));
		} catch (Exception e) {
			List<KycModel> kyc = kycservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("not found ", kyc, false));

		}
	}

	@PostMapping
	public ResponseEntity<ApiResponse<KycModel>> createKyc(@RequestBody KycModel kyc) {
		KycModel kycdata = kycservice.createKycDetails(kyc);
		ApiResponse<KycModel> response = new ApiResponse<>("created successfully", kycdata, true);
		return ResponseEntity.ok(response);
	}

	@GetMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<KycModel>>> getById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<KycModel> response = kycservice.getExixtingKycDetails(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("found by id", response, true));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<KycModel>>> deleteById(@PathVariable Long id)
			throws ResourceNotFoundException {
		Optional<KycModel> response = kycservice.deleteDetails(id);
		if (response == null) {
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("deleted successfully", response, true));
	}

}
