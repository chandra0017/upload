package com.chandrashekar.SpringbootApplication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chandrashekar.SpringbootApplication.service.ExcelService;
import com.chandrashekar.SpringbootApplication.util.ExcelUtils;


@Controller

public class InstallationController {
	@Autowired
	ExcelService excelService;
	
	@GetMapping("/uploadform")
    public String index() {
        return "uploadform";
    }
	
	@PostMapping("/uploadFile")
	  public String uploadFile(@RequestParam(value ="uploadfile",required=false) MultipartFile file, Model model) {
	    String message = "";

	    if (ExcelUtils.hasExcelFormat(file)) {
	      try {
	    	  excelService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return  "/uploadform";
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return message;
	      }
	    }

	    message = "Please upload an excel file!";
	    return message;
	  }
	
	@PostMapping("/")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) {
		try {
			excelService.save(file);
			model.addAttribute("message", "File uploaded successfully!");
		} catch (Exception e) {
			model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
        return "multipartfile/uploadform.html";
    }
	
	/*
	 * @GetMapping("/fromFile") public String uploadFile1(@RequestParam(), Model
	 * model) { String message = "";
	 * 
	 * if (ExcelUtils.hasExcelFormat(file)) { try { excelService.save(file);
	 * 
	 * message = "Uploaded the file successfully: " + file.getOriginalFilename();
	 * return "/uploadform"; } catch (Exception e) { message =
	 * "Could not upload the file: " + file.getOriginalFilename() + "!"; return
	 * message; } }
	 * 
	 * message = "Please upload an excel file!"; return message; }
	 */
}
