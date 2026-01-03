package com.orangehrm.test;

import static io.restassured.RestAssured.given;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;

import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;

public class DummyClass extends BaseClass {
	
	
	
	@Test
	void testURL() {
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "OrangeHRM");
		
		Response res = given()
		
		.when()
			.get(prop.getProperty("url"));
		
		Assert.assertEquals(res.getStatusCode(), equalTo(200));
			
		
			
		
		
	}

}
