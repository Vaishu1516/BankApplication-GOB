package com.nirmaan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmaan.project.entity.PersonalDetails;

@Repository
public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails, Integer>{

}
