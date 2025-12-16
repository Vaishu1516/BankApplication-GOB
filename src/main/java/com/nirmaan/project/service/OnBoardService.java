package com.nirmaan.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmaan.project.entity.OnBoard;
import com.nirmaan.project.repository.OnBoardRepo;

@Service
public class OnBoardService {
	@Autowired
	public OnBoardRepo onBoardRepo;

	public OnBoard createOnboardDetails(OnBoard onboard) {
		return onBoardRepo.save(onboard);
	}

	public OnBoard getExistingOnBoardDetails(long id) {
		return onBoardRepo.findById(id).get();
	}

	public Optional<OnBoard> deleteDetails(long id, String name) {
		Optional<OnBoard> onBoard = onBoardRepo.findById(id);
		onBoard.ifPresent(e -> onBoardRepo.delete(e));
		return null;
	}
}
