package com.qa.walmart.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.qa.base.Base;
import com.walmart.qa.utils.Utils;
import com.walmart.qa.webPages.Homepage;
import com.walmart.qa.webPages.LoginPage;

public class LoginPageTest extends Base {

	LoginPage loginPage;

	Homepage homepage;

	@BeforeMethod
	void setup() {
		inialisation();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	void checkLogoPresence() {

		Boolean flag = loginPage.isWalmartLogoDisplayed();

		Assert.assertTrue(flag);

	}

	@Test(priority = 2)
	void checkSearchFunctionality() {

		String resultOfSearch = loginPage.searchButtonFunctionalityCheck();

		Assert.assertEquals(resultOfSearch, "PS4");
	}

	@Test(priority = 3)
	void clickOnRightBannerArrow() {

		for (int i = 0; i < 4; i++) {

			loginPage.moveBannerRight();

		}

	}

	@Test(priority = 4)
	void clickHottestDealsTest() {

		String searchResultHottestDeal = loginPage.clickHottestDeals();

		Assert.assertEquals(searchResultHottestDeal, "Hottest deals");

	}

	@Test(priority = 5)
	void checkAboutUsWalmartTest() {

		String pageTitle = loginPage.checkAboutUsWalmart();

		Assert.assertEquals(pageTitle, "Walmart Canada - Our Story");

	}

	@Test(priority = 6)
	void checkCovidInformationTest() {

		String pageTitle = loginPage.checkCovidInformation();

		Assert.assertEquals(pageTitle, "COVID-19 — Walmart Updates | Walmart Canada");

	}

	@Test(priority = 7)
	void clickVideoGameTest() {

		String pageHeading = loginPage.clickVideoGame();

		Assert.assertEquals(pageHeading, "Video Games");

	}

	@Test(priority = 8)
	void clickLeftBottomBannerTest() {

		boolean flag = loginPage.clickLeftBottomBanner();

		Assert.assertTrue(flag);
	}

	@Test(priority = 9)
	void clickbannerWalmartMarketPlaceTest() {

		boolean flag = loginPage.clickbannerWalmartMarketPlace();

		Assert.assertTrue(flag);

	}

	@Test(priority = 10)
	public void clickOnInstagramSocialLinkTest() {

		loginPage.clickOnInstagramSocialLink();

	}

	@Test(priority = 1,enabled = false)
	void SignInTest() {

		homepage = loginPage.SignIn(prop.getProperty("username"), prop.getProperty("password"));

		boolean flag = loginPage.myAccount.isDisplayed();

		Assert.assertTrue(flag);
	}
	
	@Test(priority = 12)
	void bannerMovementDetectionTest() {
		
		loginPage.bannerMovementDetection();
		
	}

	@AfterMethod
	void tearDown() {

		driver.quit();

	}

}
