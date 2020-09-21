package com.chandrashekar.SpringbootApplication.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	
	/*
	 * @GetMapping("/reports") public ModelAndView
	 * getFinalReport( @RequestParam(value = "startTime") String
	 * startTime, @RequestParam(value = "endTime") String endTime) {
	 * 
	 * ReportingDTO reportingDTO = new ReportingDTO();
	 * 
	 * reportingDTO =procPoHypercareService.generateConsolidatedReport( startTime,
	 * endTime);
	 * 
	 * Map<String, Object> paramHash = new HashMap<>(); paramHash.put("reports",
	 * reportingDTO);
	 * 
	 * return new ModelAndView("reports", paramHash); }
	 */

}
