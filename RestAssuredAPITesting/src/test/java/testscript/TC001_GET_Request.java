package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getweatherDetails() {
		RestAssured.baseURI="https://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		String responseBody = response.getBody().asString();
		
		System.out.println("resonse body: "+responseBody);
		
		//validation
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
