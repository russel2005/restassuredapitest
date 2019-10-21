package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String empName() {
		String generatedName = RandomStringUtils.randomAlphabetic(1);
		return ("Russel" +generatedName);
	}
	
	public static String empSal() {
		String generatedSal = RandomStringUtils.randomNumeric(5);
		return generatedSal;
	}

	public static String empAge() {
		String generatedAge = RandomStringUtils.randomNumeric(2);
		return generatedAge;
	}

}
