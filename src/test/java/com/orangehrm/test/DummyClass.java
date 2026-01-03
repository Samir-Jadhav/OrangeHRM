package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;

public class DummyClass extends BaseClass {
	
	@Test
	void testURL() {
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "OrangeHRM");
	}

}
