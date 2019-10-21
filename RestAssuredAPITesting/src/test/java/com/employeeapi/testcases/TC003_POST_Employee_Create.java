package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_POST_Employee_Create extends TestBase{
	
	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	
	@BeforeClass
	void createEmployee() throws InterruptedException {
		logger.info("********** Started TC003_POST_Employee_Create **********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		
		//JSONObject is a class that represent a simple JSON. we can add key-value pairs using the put method
		//{"name":"RusselA", "salary":"12334","age":"30"}
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empName);
		requestParams.put("salary", empSal);
		requestParams.put("age", empAge);
		
		httpRequest.header("Content-Type", "application/json"); //add header stating the Request is a JSON
		httpRequest.body(requestParams.toJSONString()); //add the JSON to the body of the request
		response = httpRequest.request(Method.POST, "/create");
		
		Thread.sleep(5000);		
	}
	
	@Test
	void checkResponseBody() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSal), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
	}
	
	@Test
	void checkStatusCode() {		
		logger.info("*******Checking Status code ********");
		int statusCode = response.getStatusCode(); //getting status code
		logger.info("Status Code is --> "+ statusCode); //200
		Assert.assertEquals(statusCode, 200);		
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
		Assert.assertEquals(contentType, "text/html;charset=UTF-8");
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
	
	@AfterClass
	void tearDown() {
		logger.info("********** Finished TC001_GET_All_employees **********");
	}
}
