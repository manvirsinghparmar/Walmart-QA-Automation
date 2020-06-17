package com.walmart.qa.webPages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.walmart.qa.base.Base;

public class Homepage extends Base {
	
	
	WebDriverWait wait = new WebDriverWait(driver, 60);

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@data-automation='cart-count']")
	WebElement cartCount;

	@FindBy(xpath = "//span[@data-automation='account-user-name']")
	WebElement userName;

	List<WebElement> socialLinks = driver.findElements(By.xpath("//a[@type='socialLink']"));

	@FindBy(xpath = "//span[contains(text(),'Shop grocery')]")
	WebElement groceryStore;

	public String checkCartCount() {

		String count = "";

		try {

			wait.until(ExpectedConditions.visibilityOf(cartCount));

			count = cartCount.getText();

		} catch (Exception e) {
			System.out.println("cart is empty");
		}

		return count;

	}

	public Boolean checkAccountUserNameDisplay() {
		
		wait.until(ExpectedConditions.visibilityOf(userName));

		boolean isUsernameDisplayed = userName.isDisplayed();

		return isUsernameDisplayed;

	}

	public String checkAccountUserNameActual() {
		
		wait.until(ExpectedConditions.visibilityOf(userName));

		String name_of_Account_Holder = userName.getText();

		return name_of_Account_Holder;

	}

	public void clickGroceryStore() {

		groceryStore.click();

	}
}
