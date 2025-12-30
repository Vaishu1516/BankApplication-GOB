package com.BankingApp.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BankingApp.entity.KycVerification;

public interface KycVerificationRepo extends JpaRepository<KycVerification, Long> {

}
