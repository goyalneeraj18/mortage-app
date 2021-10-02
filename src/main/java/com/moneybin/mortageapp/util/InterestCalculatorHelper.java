package com.moneybin.mortageapp.util;

import com.moneybin.mortageapp.beans.Prospects;

public class InterestCalculatorHelper {
	public static int calculateEmi(Prospects data) {
		Double emi;
		Double rate = data.getInterest() / (12 * 100);
		Double time = Double.valueOf(data.getYears() * 12);
		Double principle = data.getTotalLoan();
		emi = principle * (rate * power(1 + rate, time)) / (power(1 + rate, time) - 1);
		return (int) Math.round(emi);
	}

	private static Double power(double d, double n) {
		double p = 1;
		for (int count = 0; count < n; count++) {
			p = p * d;
		}
		return p;
	}
}
