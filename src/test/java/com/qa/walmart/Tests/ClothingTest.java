package com.qa.walmart.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.walmart.qa.base.Base;
import com.walmart.qa.webPages.Clothing;
import com.walmart.qa.webPages.LoginPage;


@Listeners(com.qa.walmart.customeListener.CustomerListener.class)
public class ClothingTest extends Base {

	LoginPage loginpage;
	Clothing clothing;

	@BeforeMethod
	void setUp() {

		inialisation();
		
		loginpage=new LoginPage();

		clothing =loginpage.clickOnClothingPage();

		
	}
	
	
	@Test(priority = 1,enabled = false)
	void pageTitleTest() {
		
		String titleOfPage=clothing.pageTitle();
		
		Assert.assertEquals(titleOfPage, prop.getProperty("pageTitleClothingPage"));
		
		
	}
	
	@Test(priority = 2)
	void clickUrbanPlanetLinkTest() {
		
			clickUrbanPlanetLinkTest();
	}

	
	@AfterMethod
	void tearDown() {

		driver.quit();
	}

}
