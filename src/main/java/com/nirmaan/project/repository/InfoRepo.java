package com.nirmaan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmaan.project.entity.Info;

@Repository
public interface InfoRepo extends JpaRepository<Info, Long> {

}
