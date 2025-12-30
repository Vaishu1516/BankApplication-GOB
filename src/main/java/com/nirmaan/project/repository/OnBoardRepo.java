package com.nirmaan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmaan.project.entity.OnBoard;

@Repository
public interface OnBoardRepo extends JpaRepository<OnBoard, Long>{

}
