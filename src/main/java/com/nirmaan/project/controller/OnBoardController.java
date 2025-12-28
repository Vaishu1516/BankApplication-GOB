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

import com.nirmaan.project.entity.OnBoard;
import com.nirmaan.project.service.OnBoardService;

import apiresponse.ApiResponse;
import globalexcexception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/OnBoard/")
public class OnBoardController {
	
	@Autowired
	public OnBoardService onboardservice;
	
	@GetMapping("onBoardDetails")
	public ResponseEntity<ApiResponse<List<OnBoard>>> getAll(){
		try 
		{
			List<OnBoard> onboard = onboardservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("found all",onboard, true));
		}
		catch(Exception e)
		{
			List<OnBoard> onboard = onboardservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("not found", onboard, false));
		}
		
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<OnBoard>> createOnBoard(@RequestBody OnBoard onboard)
	{
		OnBoard onboarddata = onboardservice.createOnboardDetails(onboard);
		ApiResponse<OnBoard> response = new ApiResponse<OnBoard>("created successfully", onboarddata, true);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<OnBoard>>> getById(@PathVariable Long id) throws ResourceNotFoundException
	{
		Optional<OnBoard> response = onboardservice.getExistingOnBoardDetails(id);
		if(response == null)
		{
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("found by id", response , true));
		
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse<Optional<OnBoard>>> deleteById(@PathVariable Long id) throws ResourceNotFoundException
	{
		Optional<OnBoard> response = onboardservice.deleteDetails(id);
		if(response == null)
		{
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("deleted", response, true));
	}
	
}
