package com.nirmaan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmaan.project.entity.KycModel;

@Repository
public interface KycRepo extends JpaRepository<KycModel, Long> {

}
