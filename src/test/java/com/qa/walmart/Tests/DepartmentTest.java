package com.qa.walmart.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.Base;
import com.walmart.qa.webPages.Department;
import com.walmart.qa.webPages.LoginPage;

public class DepartmentTest extends Base {

	Department department;

	@BeforeMethod
	void setup() {
		
		

		inialisation();
		
		department=new Department();

	}

	@Test
	void goToDepartmentAndSelectAutomotiveTest() {

		String titleOfTvAccessoriesPage=department.goToDepartmentAndSelectTvAccessories();
		
		Assert.assertEquals(titleOfTvAccessoriesPage, "TV, Audio & Video Accessories | Walmart Canada");

	}

	@AfterMethod
	void tearDown() {

		driver.quit();

	}
}
