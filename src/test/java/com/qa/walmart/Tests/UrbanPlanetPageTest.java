package com.qa.walmart.Tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Priority;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.walmart.qa.base.Base;
import com.walmart.qa.webPages.Clothing;
import com.walmart.qa.webPages.LoginPage;
import com.walmart.qa.webPages.UrbanPlanetPage;

public class UrbanPlanetPageTest extends Base {

	LoginPage loginpage;
	Clothing clothing;
	UrbanPlanetPage urbanPlanetPage;

	SoftAssert softAssert;

	@BeforeMethod
	void setUp() {

		inialisation();

		loginpage = new LoginPage();

		clothing = loginpage.clickOnClothingPage();

		urbanPlanetPage = clothing.clickUrbanPlanetButton();

		softAssert = new SoftAssert();

	}

	@Test(priority = 1)
	void verifyUrbanPlanetImageOnTopOfScreenTest() {

		boolean flag = urbanPlanetPage.verifyUrbanPlanetImageOnTopOfScreen();

		Assert.assertTrue(flag);

	}

	@Test(priority = 2)
	void decrementButtonisNotEnabledTest() {

		boolean flag = urbanPlanetPage.decrementButtonisNotEnabled();

		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	void verifyDressSizeTest() {

		String sizeOfDress = urbanPlanetPage.verifyDressSize();

		Assert.assertEquals(sizeOfDress, "7");
	}

	@Test(priority = 4)
	void verifyQtyTest() {

		String orderedQty = urbanPlanetPage.verifyQty();

		softAssert.assertEquals(orderedQty, "2");

	}
	
	
	@Test(priority=5)
	void productAddedToCartTest() {
		
		String productSucessFullyAddedToCart=urbanPlanetPage.productAddedToCart();
		
		Assert.assertEquals(productSucessFullyAddedToCart, prop.getProperty("sucessMessageAddedToCart"));
		
		
	}

	@AfterMethod
	void tearDown() {

		driver.quit();
	}

}
