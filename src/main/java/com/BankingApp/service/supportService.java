package com.BankingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.BankingApp.entity.Support;
import com.BankingApp.repositiory.SupportRepo;

public class supportService {
	 @Autowired
	 
     public SupportRepo supportRepo;

     public Support createSupportDetails(Support support) {
             return supportRepo.save(support);

     }

     public Support getExistingDetails(long id) {
             return supportRepo.findById(id).get();
     }

     public Optional<Support> deleteDetails(long id, String name) {
             Optional<Support> support = supportRepo.findById(id);
             support.ifPresent(e -> supportRepo.delete(e));
             return support;
     }

}
