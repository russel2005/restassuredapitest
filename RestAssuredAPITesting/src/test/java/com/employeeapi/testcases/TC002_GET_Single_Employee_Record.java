package com.employeeapi.testcases;

import org.testng.annotations.BeforeClass;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_GET_Single_Employee_Record extends TestBase{

	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		logger.info("********** Started TC001_GET_All_employees **********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employee/" + empID);
		
		Thread.sleep(3000);
	}
}
