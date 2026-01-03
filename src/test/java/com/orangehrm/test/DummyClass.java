package com.orangehrm.test;

import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;

public class DummyClass extends BaseClass {
	
	
	
	@Test
	void testURL() {
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "OrangeHRM");
		
		given()
		
		.when()
			.get(prop.getProperty("url"))
			
		.then()
			.statusCode(200);
		
		
	}

}
