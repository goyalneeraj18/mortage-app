package com.moneybin.mortageapp.controller;

import com.moneybin.mortageapp.beans.Prospects;
import com.moneybin.mortageapp.service.InterestCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
	@Autowired
	private InterestCalculateService interestCalculateService;

	@Autowired
	private Prospects prospects;

	@RequestMapping("/")
	public String getHome() {
		return "home";
	}

	@GetMapping("/showMortage")
	public ModelAndView getHome(@RequestParam("customerName") String customer,
			@RequestParam("totalloan") Double totalLoan, @RequestParam("interest") Double interest,
			@RequestParam("years") int years) {

		prospects.setCustomer(customer);
		prospects.setTotalLoan(totalLoan);
		prospects.setInterest(interest);
		prospects.setYears(years);

		int emi = interestCalculateService.calculateEmi(prospects);

		Map<String, Object> model = new HashMap<>();
		model.put("emi", emi);

		return new ModelAndView("home", model);
	}
}
