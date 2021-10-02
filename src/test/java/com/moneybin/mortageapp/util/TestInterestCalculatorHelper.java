package com.moneybin.mortageapp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.moneybin.mortageapp.beans.Prospects;
import org.junit.jupiter.api.Test;

public class TestInterestCalculatorHelper {

	InterestCalculatorHelper helper = new InterestCalculatorHelper();

	@Test
	void testEmiCalculation() {
		Prospects prospects = new Prospects();
		prospects.setTotalLoan(10000.0);
		prospects.setInterest(24.0);
		prospects.setYears(1);
		assertEquals(946, helper.calculateEmi(prospects));
	}
}
