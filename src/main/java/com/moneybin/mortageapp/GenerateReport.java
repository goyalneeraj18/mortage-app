package com.moneybin.mortageapp;

import com.moneybin.mortageapp.beans.Prospects;
import com.moneybin.mortageapp.util.InterestCalculatorHelper;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class GenerateReport {

	public static void main(String[] args) {
		List<Prospects> prospectsList = new ArrayList<>();
		PrintWriter pw = null;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(new ClassPathResource("static/prospects.txt").getURI()),
					StandardCharsets.UTF_8);
			pw = new PrintWriter("output.txt", "UTF-8");

			prospectsList = readAll(reader);
			prospectsList = prospectsList.stream().filter(prospects -> prospects.getTotalLoan() != null).collect(Collectors.toList());
		} catch (IOException | CsvException e) {
			log.error("Exception occured while reading the input file "+e.getMessage());
			e.printStackTrace();
		}
		for (Prospects prospects : prospectsList) {
			int emi = InterestCalculatorHelper.calculateEmi(prospects);
			pw.println(prospects.getCustomer() + " wants to borrow " + prospects.getTotalLoan() + " € for a period of "
					+ prospects.getYears() + " years and pay " + emi + " € each month");
		}
		pw.close();
	}

	public static List<Prospects> readAll(Reader reader) throws IOException, CsvException {
		ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
		strategy.setType(Prospects.class);
		String[] memberFieldsToBindTo = {"customer", "totalLoan", "interest", "years"};
		strategy.setColumnMapping(memberFieldsToBindTo);

		return new CsvToBeanBuilder(reader)
				.withMappingStrategy(strategy)
				.withSkipLines(1)
				.withIgnoreLeadingWhiteSpace(true)
				.build().parse();
	}
}
