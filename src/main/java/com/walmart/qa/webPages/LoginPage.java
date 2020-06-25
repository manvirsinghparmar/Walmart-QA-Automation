package com.walmart.qa.webPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.walmart.qa.base.Base;
import com.walmart.qa.utils.Utils;

public class LoginPage extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 60);

	Actions action = new Actions(driver);

	SoftAssert softAssert = new SoftAssert();

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "walmartblue_Layer_1")
	WebElement walmartLogo;

	@FindBy(xpath = "//input[@placeholder='What are you looking for?']")
	WebElement searchBoxHomePage;

	@FindBy(xpath = "//button[@data-automation='search-form-submit']")
	WebElement searchButtonHomePage;

	@FindBy(xpath = "//h1[contains(text(),'PS4')]")
	WebElement searchResultKeyword;

	@FindBy(xpath = "//div[contains(@class,'css-eluaty e1dldmnj5')]")
	WebElement bannerArrow;

	@FindBy(xpath = "//img[contains(@title,'Style')]")
	WebElement detectMovementOfBanner;

	@FindBy(xpath = "//div[@class='css-alhzo4 e16kzl6s0']//img[@class='css-lu5rme e16kzl6s3']")
	WebElement hottestDeals;

	@FindBy(xpath = "//h1[contains(text(),'Hottest deals')]")
	WebElement hottestDealsClickResult;

	@FindBy(xpath = "//div[@class='css-u32psb ek2b3712']//a[contains(text(),'About Walmart') ]")
	WebElement aboutWalmart;

	@FindBy(xpath = "//div[contains(@style,'calc(23.1884% + 0.5px)')]")
	WebElement bottomBanner;

	@FindBy(xpath = "//img[@alt='Walmart Rewards MasterCard.']")
	WebElement clickResultbottomBannerImageOfMasterCard;

	@FindBy(xpath = "//div[@class='css-1f9gjts' and contains(@style,'calc(12.056737588652481%')]")
	WebElement bannerWalmartMarketPlace;

	@FindBy(id = "j_id0:theImage")
	WebElement marketPlaceLogo;

	@FindBy(xpath = "//div[@class='css-1f9gjts' and contains(@style,'calc(3.546099290780142% ')]")
	WebElement covidInformation;

	@FindBy(xpath = "//span[contains(text(),'Video games')]")
	WebElement videoGames;

	@FindBy(xpath = "//h1[contains(text(),'Video Games')]")
	WebElement videoGamePageText;

	@FindBy(xpath = "//span[contains(text(),'Sign in')]")
	WebElement accountMenu;

	@FindBy(id = "login-form-email")
	WebElement enterUserEmailID;

	@FindBy(xpath = "//input[@name='password']")
	WebElement enterUserPassword;

	@FindBy(id = "account-signin-btn")
	WebElement signInButton;

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	public WebElement myAccount;

	List<WebElement> socialLinks = driver.findElements(By.xpath("//a[@type='socialLink']"));
	
	@FindBy(css = "ul[class='css-1ntok35 e8z2aj20']>li:last-of-type")
	WebElement clothingPage;

	public boolean isWalmartLogoDisplayed() {

		Boolean isDisplayedOnHomePage = walmartLogo.isDisplayed();

		return isDisplayedOnHomePage;

	}

	public String searchButtonFunctionalityCheck() {

		searchBoxHomePage.sendKeys(prop.getProperty("searchText"));

		searchButtonHomePage.submit();

		String resultOfSearch = searchResultKeyword.getText();

		return resultOfSearch;

	}

	public void moveBannerRight() {

		bannerArrow.click();

	}

	public void bannerMovementDetection() {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@style,'-5632')]")));

	}

	public String clickHottestDeals() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hottestDeals);

		hottestDeals.click();

		wait.until(ExpectedConditions.visibilityOf(hottestDealsClickResult));

		String searchResultHottestDeal = hottestDealsClickResult.getText();

		return searchResultHottestDeal;

	}

	public String checkAboutUsWalmart() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutWalmart);

		aboutWalmart.click();

		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		String pageTitle = driver.getTitle();

		return pageTitle;

	}

	public String checkCovidInformation() {

		softAssert.assertTrue(covidInformation.isDisplayed());

		covidInformation.click();

		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'COVID-19 — Walmart Updates')]"))));

		String pageTitle = driver.getTitle();

		return pageTitle;

	}

	public String clickVideoGame() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", videoGames);

		videoGames.click();

		wait.until(ExpectedConditions.visibilityOf(videoGamePageText));

		String pageHeading = videoGamePageText.getText();

		return pageHeading;

	}

	public boolean clickLeftBottomBanner() {

		wait.until(ExpectedConditions.visibilityOf(bottomBanner));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bottomBanner);

		bottomBanner.click();

		wait.until(ExpectedConditions.visibilityOf(clickResultbottomBannerImageOfMasterCard));

		Boolean isMasterCardImageVisible = clickResultbottomBannerImageOfMasterCard.isDisplayed();

		return isMasterCardImageVisible;

	}

	public boolean clickbannerWalmartMarketPlace() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bannerWalmartMarketPlace);

		bannerWalmartMarketPlace.click();

		wait.until(ExpectedConditions.visibilityOf(marketPlaceLogo));

		Boolean isMarketPlaceLogoDisplayed = marketPlaceLogo.isDisplayed();

		return isMarketPlaceLogoDisplayed;

	}

	public Homepage SignIn(String uName, String uPassword) {

		accountMenu.click();

		wait.until(ExpectedConditions.visibilityOf(enterUserEmailID));

		enterUserEmailID.sendKeys(uName);
		enterUserPassword.sendKeys(uPassword);

		signInButton.click();

		return new Homepage();
	}

	public void clickOnInstagramSocialLink() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", socialLinks.get(3));

		socialLinks.get(3).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public Clothing clickOnClothingPage() {
		
		clothingPage.click();
		
		return new Clothing();
		
	}

}
