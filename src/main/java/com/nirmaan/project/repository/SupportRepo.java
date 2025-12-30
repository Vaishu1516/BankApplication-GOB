package com.nirmaan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmaan.project.entity.Support;

@Repository
public interface SupportRepo extends JpaRepository<Support, Long> {

}
