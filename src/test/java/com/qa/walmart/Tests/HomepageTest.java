package com.qa.walmart.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.Base;
import com.walmart.qa.webPages.Homepage;
import com.walmart.qa.webPages.LoginPage;

public class HomepageTest extends Base {

	Homepage homepage;

	LoginPage login;

	@BeforeMethod
	public void setUp() {

		inialisation();

		homepage = new Homepage();

		login = new LoginPage();

		login.SignIn(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1, enabled = false)
	void checkCartCountTest() {

		String count_of_items_in_cart = homepage.checkCartCount();

		Assert.assertEquals(count_of_items_in_cart, 0);

	}

	@Test(priority = 2, enabled = false)
	void checkAccountUserNameDisplayTest() {

		boolean flag = homepage.checkAccountUserNameDisplay();

		Assert.assertTrue(flag);

	}
	
	@Test(priority = 3,enabled = false)
	void checkAccountUserNameActualTest() {
		
		String nameOfAccountHolder=homepage.checkAccountUserNameActual();
		
		Assert.assertEquals(nameOfAccountHolder, "Hi Manvir");
	}
	
	

	@AfterMethod
	void tearDown() {

		driver.quit();

	}
}
