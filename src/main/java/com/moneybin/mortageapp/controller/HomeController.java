package com.moneybin.mortageapp.controller;

import com.moneybin.mortageapp.beans.Prospects;
import com.moneybin.mortageapp.service.InterestCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	private Prospects prospects;

	@RequestMapping("/")
	public String getHome() {
		return "home";
	}
}
