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

import com.nirmaan.project.entity.Info;
import com.nirmaan.project.service.InfoService;

import apiresponse.ApiResponse;
import globalexcexception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/Info/")
public class InfoController {
	
	@Autowired
	public InfoService infoservice;
	
	@GetMapping("InfoDetails")
	public ResponseEntity<ApiResponse<List<Info>>> getAll()
	{
		try {
			List<Info> info = infoservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("found ", info, true));
		}
		catch (Exception e)
		
		{
			List<Info> info = infoservice.getAll();
			return ResponseEntity.ok(new ApiResponse<>("not found", info, false));
		}
		
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<Info>> createAllInfo(@RequestBody Info info)
	{
		Info infodata = infoservice.createInfoDetails(info);
		ApiResponse<Info> response = new  ApiResponse<>("info created ", infodata , true);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Optional<Info>>> getById(@PathVariable Long id) throws ResourceNotFoundException
	{
		Optional<Info> response = infoservice.getExistingDetails(id);
		if(response == null )
		{
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("id found", response , true));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Optional<Info>>> deleteInfo(@PathVariable Long id) throws ResourceNotFoundException
	{
	
		Optional<Info> response = infoservice.deleteDetails(id);
		if(response == null)
		{
			throw new ResourceNotFoundException();
		}
		return ResponseEntity.ok(new ApiResponse<>("deleted", response, true));
	}

}
