package org.serializationvelsir;

import java.util.LinkedList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.baseclass.BaseClass;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class LoginClass extends BaseClass {

	@Test(priority=1)
	private void loginPage() {
		addHeader("accept", "application/json");
		basicAuth("greenstechchennaiomr@gmail.com", "KeepGoal@2022");

		Response response = reqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

		int statusCode = response.getStatusCode();
		String resBodyAsprettyString = getResBodyAsprettyString(response);
		System.out.println(resBodyAsprettyString);

		Root output = response.as(Root.class);
		String message = output.getMessage();
		System.out.println(message);

		//Assert.assertEquals(message, "Login successfully", "Verify Login successfully");
		// output.getData().getlo

	}
@Test(priority=2)
private void address() {
	List<Header> list = new LinkedList<Header>();
	addHeader("accept", "application/json");
	addHeader("Content-Type","application/json");
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
