package com.BankingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.BankingApp.entity.Info;
import com.BankingApp.repositiory.InfoRepo;

public class InfoService {
	  @Autowired
      public InfoRepo infoRepo;

      public Info createInfoDetails(Info info) {
              return infoRepo.save(info);
      }

      public Info getExistingDetails(long id) {
              return infoRepo.findById(id).get();
      }

      public Optional<Info> deleteDetails(long id, String name) {
              Optional<Info> info = infoRepo.findById(id);
              info.ifPresent(e -> infoRepo.delete(e));
              return info;
      }

}
