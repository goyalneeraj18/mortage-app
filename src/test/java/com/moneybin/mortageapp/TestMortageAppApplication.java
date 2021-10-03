package com.moneybin.mortageapp;

import com.moneybin.mortageapp.controller.HomeController;
import com.moneybin.mortageapp.controller.IntertestCalculatorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class TestMortageAppApplication {

	@Autowired
	private IntertestCalculatorController intertestCalculatorController;

	@Autowired
	private HomeController homeController;

	@BeforeEach
	public void init() {
	}

	@Test
	public void contexLoads() {
		assertThat(intertestCalculatorController).isNotNull();
		assertThat(homeController).isNotNull();
	}

	@Test
	public void testEmiCalculateForCustomer() {
		int emi = intertestCalculatorController.calculateEMIForACustomer("test_customer", 10000.0, 24.0, 1);
		assertEquals(946, emi, "EMI is not calculated correctly");
	}

	@Test
	public void testEmiCalculateForAllData() {
		List<String> list = intertestCalculatorController.getMortageCalculateForAllCustomerData();
		assertEquals(4, list.size());
	}
}
