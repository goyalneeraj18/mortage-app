package com.moneybin.mortageapp.service;

import com.moneybin.mortageapp.beans.Prospects;
import com.moneybin.mortageapp.repository.InterestCalculateRepository;
import com.moneybin.mortageapp.util.InterestCalculatorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InterestCalculateService {
	@Autowired
	private InterestCalculateRepository repository;

	public int calculateEmi(Prospects data) {
		return InterestCalculatorHelper.calculateEmi(data);
	}

	public Map<Prospects, Integer> fetchCustomerDataAndCalculateEMI() {
		Map<Prospects, Integer> dataMap = new HashMap<>();
		List<Prospects> customerDataList = getCustomersData();
		for (Prospects prospects : customerDataList) {
			int emi = calculateEmi(prospects);
			dataMap.put(prospects, emi);
		}
		return dataMap;
	}

	public List<Prospects> getCustomersData() {
		return repository.findAll();
	}
}
