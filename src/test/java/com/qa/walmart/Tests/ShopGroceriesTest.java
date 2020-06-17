package com.qa.walmart.Tests;

import java.util.ArrayList;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.Base;
import com.walmart.qa.webPages.ShopGroceries;
import com.walmart.qa.webPages.SummerOfSavings;

public class ShopGroceriesTest extends Base {

	ShopGroceries shopgroceries;

	@BeforeMethod
	void setUp() {

		inialisation();

		shopgroceries = new ShopGroceries();

	}

	@Test(priority = 1)
	void verifyPageTitleTest() {

		String titleOfPage = shopgroceries.verifyPageTitle();

		Assert.assertEquals(titleOfPage, prop.getProperty("shopGroceryPageTitle"));

	}

	@Test(priority = 2)
	void verifyfaceBookLogoColorTest() {

		String colorOfLogo = shopgroceries.verifyfaceBookLogoColor();

		Assert.assertEquals(colorOfLogo, "#427d00");

	}

	@Test(priority = 3)
	void verifyFuntionalityOfAddingItemsToCartTest() {

		String itemCount = shopgroceries.verifyFuntionalityOfAddingItemsToCart();

		Assert.assertEquals(itemCount, prop.getProperty("itemsInGroceryCart"));
	}

	@Test(priority = 4)
	void locationTest() {

		ArrayList<Point> listOfPoints = shopgroceries.elementSequenceOrder();

		for (int i = 0; i < listOfPoints.size(); i++) {

			System.out.println(listOfPoints.get(i));

		}

	}

	@AfterMethod
	void tearDown() {

		driver.quit();
	}

}
