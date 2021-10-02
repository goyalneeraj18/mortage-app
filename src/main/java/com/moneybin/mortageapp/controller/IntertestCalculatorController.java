package com.moneybin.mortageapp.controller;

import com.moneybin.mortageapp.beans.Prospects;
import com.moneybin.mortageapp.service.InterestCalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/mortageCalculate")
public class IntertestCalculatorController {

	@Autowired
	private InterestCalculateService interestCalculateService;
	@Autowired
	private Prospects data;

	@GetMapping("/customer")
	public int calculateEMIForACustomer(@RequestParam("customerName") String customer,
			@RequestParam("totalloan") Double totalLoan, @RequestParam("interest") Double interest,
			@RequestParam("years") int years) {
		data.setCustomer(customer);
		data.setTotalLoan(totalLoan);
		data.setInterest(interest);
		data.setYears(years);
		return interestCalculateService.calculateEmi(data);
	}

	@GetMapping(value = "/getAll")
	public Map<Prospects, Integer> getMortageCalculateForAllCustomerData() {
		return interestCalculateService.fetchCustomerDataAndCalculateEMI();
	}
}
