package com.nirmaan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmaan.project.entity.Verifications;

@Repository
public interface VerificationsRepo extends JpaRepository<Verifications, Long> {

}
