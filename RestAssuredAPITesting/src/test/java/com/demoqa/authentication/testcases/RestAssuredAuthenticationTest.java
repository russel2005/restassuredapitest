package com.demoqa.authentication.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.authentication.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAuthenticationTest extends BaseClass{
	
	@Test
	public void testResponse() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Status message " + response.body().asString());
	}

	@Test
	public void testStatsusCode() {
		int code = RestAssured.given()
				.get()
				.getStatusCode();
		System.out.println("response code is " + code);
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void testWithInvalidCredential() {
		RestAssured.authentication = RestAssured.preemptive().basic("Tools", "TestPassword");
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		//response = request.request(Method.GET,"/emp");
		int code = response.getStatusCode();
		System.out.println("for invalid credintial, response code is " + code);
		Assert.assertEquals(code, 401);
		
		
	}
}
