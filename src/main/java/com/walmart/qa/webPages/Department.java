package com.walmart.qa.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.walmart.qa.base.Base;

public class Department extends Base {

	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);

	public Department() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Departments')]")
	WebElement department;

	@FindBy(id = "4")
	WebElement electronics;

	@FindBy(xpath = "//a[contains(text(),'TV Accessories')]")
	WebElement tvAccessories;

	public String goToDepartmentAndSelectTvAccessories() {
		System.out.println("Inside");

		action.moveToElement(department).build().perform();

		wait.until(ExpectedConditions.visibilityOf(electronics));

		action.moveToElement(electronics).click().build().perform();

		wait.until(ExpectedConditions.visibilityOf(tvAccessories));

		tvAccessories.click();

		return driver.getTitle();

	}

}
