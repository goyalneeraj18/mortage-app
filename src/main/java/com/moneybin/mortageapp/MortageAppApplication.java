package com.moneybin.mortageapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.moneybin.mortageapp")
public class MortageAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MortageAppApplication.class, args);
	}
}
