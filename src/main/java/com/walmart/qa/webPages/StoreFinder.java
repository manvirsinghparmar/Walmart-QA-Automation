package com.walmart.qa.webPages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walmart.qa.base.Base;

public class StoreFinder extends Base {

	WebDriverWait wait = new WebDriverWait(driver, 15);

	Alert alert;

	public StoreFinder() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Store finder')]")
	WebElement storeFinder;

	@FindBy(xpath = "//button[(@title='Zoom in')]")
	WebElement zoomIn;

	@FindBy(xpath = "//button[(@title='Zoom out')]")
	WebElement zoomOut;

	@FindBy(xpath = "//input[@placeholder='Enter a city or postal code']")
	WebElement location;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchButton;

	@FindBy(xpath = "//span[(contains(text(),'Showing 20 stores'))]")
	WebElement totalNoOfResult;

	@FindBy(xpath = "//h2[contains(text(),'Brampton')]")
	List<WebElement> searchResult;

	@FindBy(xpath = "//button[contains(text(),'Use my location')]")
	WebElement useLocationToSearch;

	@FindBy(xpath = "//button[(contains(text(),'Filter'))]")
	WebElement filterButton;

	@FindBy(xpath = "//span[(contains(text(),'Grocery Pickup'))]")
	WebElement groceryPickUpCheckBoxText;

	@FindBy(xpath = "//label[@title='Grocery Pickup']//input[@type='checkbox']")
	WebElement groceryPickUpCheckBox;

	@FindBy(xpath = "//button[(contains(text(),'Apply'))]")
	WebElement applyFilter;

	@FindBy(xpath = "//div[@class='container']//span[(contains(text(),'Filters applied.'))]")
	WebElement filterResult;

	public String pageTitleOfStoreFinder() {

		storeFinder.click();

		String pageTitle = driver.getTitle();

		return pageTitle;

	}

	public List<WebElement> searchLocation() {

		storeFinder.click();

		wait.until(ExpectedConditions.visibilityOf(location));

		location.clear();

		location.sendKeys(prop.getProperty("nameOfSearchCity"));

		searchButton.click();

		System.out.println("Search Result size is :" + searchResult);

		return searchResult;

	}

	public String clickSearchLocation() {

		storeFinder.click();

		useLocationToSearch.click();

		// wait.until(ExpectedConditions.visibilityOf(totalNoOfResult));

		return totalNoOfResult.getAttribute("innerHTML");

	}

	public boolean clickFilterButton() {

		storeFinder.click();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", filterButton);

		groceryPickUpCheckBoxText.click();

		return groceryPickUpCheckBox.isSelected();

	}

	public String filterResult() {

		storeFinder.click();

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", filterButton);

		wait.until(ExpectedConditions.visibilityOf(groceryPickUpCheckBoxText));

		groceryPickUpCheckBoxText.click();

		applyFilter.click();

		return filterResult.getAttribute("innerHTML");

	}

	public void zoomIn() {

		storeFinder.click();

		for (int i = 0; i < 3; i++) {

			zoomIn.click();
		}
	}

	public void zoomOut() {

		storeFinder.click();

		for (int i = 0; i < 3; i++) {

			zoomOut.click();
		}
	}

}
