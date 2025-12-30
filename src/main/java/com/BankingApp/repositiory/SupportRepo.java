package com.BankingApp.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BankingApp.entity.Support;

public interface SupportRepo extends JpaRepository<Support, Long> {

}
