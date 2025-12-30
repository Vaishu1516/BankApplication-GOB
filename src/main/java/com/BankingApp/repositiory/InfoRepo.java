package com.BankingApp.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BankingApp.entity.Info;

public interface InfoRepo extends JpaRepository<Info, Long> {

}
