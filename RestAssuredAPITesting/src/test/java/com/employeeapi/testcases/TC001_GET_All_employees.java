package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GET_All_employees extends TestBase{
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		logger.info("********** Started TC001_GET_All_employees **********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseBody() {		
		logger.info("*******Checking Response Body ********");
		String responseBody = response.getBody().asString();
		logger.info("Response Body--> "+responseBody);
		Assert.assertTrue(responseBody != null);		
	}
	
	@Test
	void checkStatusCode() {		
		logger.info("*******Checking Status code ********");
		int statusCode = response.getStatusCode(); //getting status code
		logger.info("Status Code is --> "+ statusCode); //200
		Assert.assertEquals(statusCode, 200);		
	}
	
	@Test
	void checkResponseTime() {		
		logger.info("*******Checking Response Time ********");
		long responseTime = response.getTime(); //getting status Line
		logger.info("Response Time is --> " + responseTime);
		
		if(responseTime>2000)
			logger.warn("Response Time is greater than 2000.");
		
		Assert.assertTrue(responseTime<2000);
	}
	
	@Test
	void checkStatusLine(){		
		logger.info("*******Checking Status Line ********");
		String statusLine = response.getStatusLine(); //getting stsatus line
		logger.info("Status Line is --> " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void checkContentType() {		
		logger.info("*******Checking Content Type ********");
		String contentType = response.header("Content-Type"); 
		logger.info("Content Type is --> " + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}
	
	@Test
	void checkServerType() {		
		logger.info("*******Checking Server Type ********");
		String serverType = response.header("Server"); 
		logger.info("Server Type is --> " + serverType);
		Assert.assertEquals(serverType, "nginx/1.16.0");
	}

	@Test
	void checkContentEncoding() {		
		logger.info("*******Checking Content Encoding ********");
		String contentEncoding = response.header("Content-Encoding"); 
		logger.info("Content Encoding is --> " + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}
	
	@Test
	void checkContentLength() {		
		logger.info("*******Checking Content Length ********");
		String contentLength = response.header("Content-Length"); 
		logger.info("Content Length is --> " + contentLength);

		if(Integer.parseInt(contentLength)>100)
			logger.warn("Content Lenth is greater than 100.");
		
		Assert.assertTrue(Integer.parseInt(contentLength)<100);
	}
	
	@AfterClass
	void tearDown() {
		logger.info("********** Finished TC001_GET_All_employees **********");
	}
	
}
