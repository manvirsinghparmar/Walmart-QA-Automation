package com.qa.walmart.Tests;

import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.Base;
import com.walmart.qa.webPages.SummerOfSavings;

public class SummerOfSavingTest extends Base {

	SummerOfSavings summerofsavings;

	@BeforeMethod
	void setUp() {

		inialisation();
		summerofsavings = new SummerOfSavings();

	}

	@Test(priority = 1)
	void clickSummerOfSavingsTest() {

		String titleOfPage = summerofsavings.clickSummerOfSavings();

		Assert.assertEquals(titleOfPage, prop.getProperty("summerOfSavingsPageTitle"));

	}

	@Test(priority = 2)
	void clickExcerciseOfFitnessTest() {

		String titleOfPageExcercise = summerofsavings.clickExcerciseOfFitness();

		Assert.assertEquals(titleOfPageExcercise, prop.getProperty("excerciseAndFitness"));

	}

	@Test(priority = 3, expectedExceptions = ElementClickInterceptedException.class)
	void enterValidEmailTest() {

		String sucessMessage = summerofsavings.enterValidEmail();

		Assert.assertEquals(sucessMessage, prop.getProperty("validEmailSucessMessage"));

	}
	
	@Test(priority = 4,expectedExceptions = ElementClickInterceptedException.class)
	void enterInvalidEmail() {
		
		String errorMessage=summerofsavings.enterInvalidEmail();
		
		Assert.assertEquals(errorMessage, prop.getProperty("inValidEmailErrorMessage"));
	}
	
	@Test(priority = 5)
	void verifyGiftCardTest() {
		
		boolean flag=summerofsavings.verifyGiftCard();
		
		Assert.assertTrue(flag);
		
	}
	
	
	@AfterMethod
	void tearDown() {
		
		driver.quit();
	}

	
}
