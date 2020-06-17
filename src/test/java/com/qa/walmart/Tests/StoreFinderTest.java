package com.qa.walmart.Tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.Base;
import com.walmart.qa.webPages.LoginPage;
import com.walmart.qa.webPages.StoreFinder;

public class StoreFinderTest extends Base {

	StoreFinder storefinder;

	@BeforeMethod
	void setup() {

		inialisation();

		storefinder = new StoreFinder();

	}

	@Test(priority = 1)
	void pageTitleOfStoreFinderTest() {

		String pageTitle = storefinder.pageTitleOfStoreFinder();

		Assert.assertEquals(pageTitle, prop.getProperty("storeFinderPageTitle"));

	}

	@Test(priority = 7)
	void searchLocationTest() {

		List<WebElement> result_of_Search = storefinder.searchLocation();

		for (int i = 0; i < result_of_Search.size(); i++) {
			
			System.out.println("Test number: " + i);

			Assert.assertTrue(result_of_Search.get(i).getText().contains("Brampton"));
			
			System.out.println("Test " + i + "Passed");

		}

	}

	@Test(priority = 6)
	void clickSearchLocationTest() {
		String totalSearchResult = storefinder.clickSearchLocation();

		Assert.assertEquals(totalSearchResult, "Showing 20 stores");

	}

	@Test(priority = 5)
	void clickFilterButtonTest() {

		boolean flag = storefinder.clickFilterButton();

		Assert.assertTrue(flag);

	}

	@Test(priority = 4)
	void filterResultTest() {

		String resultOfApplyingFilter = storefinder.filterResult();
		System.out.println("Filter Result:" + resultOfApplyingFilter);

		Assert.assertEquals(resultOfApplyingFilter, "Filters applied.");

	}

	@Test(priority = 2)
	void zoomInTest() {

		storefinder.zoomIn();
	}

	@Test(priority = 3)
	void zoomOutTest() {

		storefinder.zoomOut();

	}

	@AfterMethod
	void tearDown() {

		driver.quit();

	}

}
