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

import com.walmart.qa.base.Base;

public class SummerOfSavings extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 30);

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	public SummerOfSavings() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".css-1ntok35.e8z2aj20>li:first-of-type")
	WebElement summerOfSavings;

	@FindBy(css = "article[title='Exercise & fitness']")
	WebElement excerciseOfFitness;

	@FindBy(css = "span[class='error']")
	WebElement errorMessage;

	@FindBy(xpath = "//section[@id='subscribe_form_a']//button[@id='newsletter-button']")
	WebElement newsLetterButton;

	@FindBy(css = "span#footer-sbscr-cnfmtn")
	List<WebElement> sucessMessage;

	@FindBy(css = "input[placeholder='Enter your email here']")
	WebElement enterEmail;

	@FindBy(xpath = "//a//img[@role='none']")
	WebElement giftCard;
	
	@FindBy(xpath="//a[@data-analytics-type]//span[contains(text(),'Exercise & Fitness')]")
	WebElement confirmationOFPageLoad;

	public String clickSummerOfSavings() {

		summerOfSavings.click();
		
		wait.until(ExpectedConditions.visibilityOf(excerciseOfFitness));

		String pageTitle = driver.getTitle();

		return pageTitle;
	}

	public String clickExcerciseOfFitness() {

		summerOfSavings.click();

		excerciseOfFitness.click();
		
		wait.until(ExpectedConditions.visibilityOf(confirmationOFPageLoad));

		String pageTitleExcercise = driver.getTitle();

		return pageTitleExcercise;

	}

	public boolean verifyGiftCard() {

		summerOfSavings.click();

		jse.executeScript("arguments[0].scrollIntoView(true);", giftCard);

		return giftCard.isDisplayed();

	}

	public String enterValidEmail() {

		summerOfSavings.click();

		jse.executeScript("arguments[0].scrollIntoView(true);", enterEmail);

		enterEmail.sendKeys(prop.getProperty("validEmail"));

		newsLetterButton.click();

		return sucessMessage.get(0).getAttribute("innerHTML");
	}

	public String enterInvalidEmail() {

		summerOfSavings.click();

		enterEmail.sendKeys(prop.getProperty("inValidEmail"));

		newsLetterButton.click();

		return errorMessage.getAttribute("innerHTML");

	}

}
