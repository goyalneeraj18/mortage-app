package com.moneybin.mortageapp.service;

import com.moneybin.mortageapp.beans.Prospects;
import com.moneybin.mortageapp.repository.InterestCalculateRepository;
import com.moneybin.mortageapp.util.InterestCalculatorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterestCalculateService {
	@Autowired
	private InterestCalculateRepository repository;

	public int calculateEmi(Prospects data) {
		return InterestCalculatorHelper.calculateEmi(data);
	}

	public List<String> fetchCustomerDataAndCalculateEMI() {
		List<String> list = new ArrayList<>();
		List<Prospects> customerDataList = getCustomersData();
		for (Prospects prospects : customerDataList) {
			int emi = calculateEmi(prospects);
			list.add(prospects.getCustomer()+" wants to borrow "+ prospects.getTotalLoan() + " € for a period of "
							+ prospects.getYears() + " years and pay " + emi + " € each month");
		}
		return list;
	}

	public List<Prospects> getCustomersData() {
		return repository.findAll();
	}
}
