package com.chandrashekar.SpringbootApplication.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chandrashekar.SpringbootApplication.model.InstallationDetails;
import com.chandrashekar.SpringbootApplication.repository.InstallationRepository;
import com.chandrashekar.SpringbootApplication.util.ExcelUtils;
@Service
public class ExcelService {
	@Autowired
	InstallationRepository installRepo;
	
	public void save(MultipartFile file) {
	    try {
	      List<InstallationDetails> tutorials = ExcelUtils.excelToTutorials(file.getInputStream());
	      installRepo.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }
	

}
