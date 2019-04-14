package com.ipms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fromHome")
public class ComeFromHomeController {
	
	@RequestMapping("/withStatus")
	public String withStatusPage(@ModelAttribute("status") String status) {
		System.out.println(status);
		return "listOneStatusPlan";
	}
	
}
