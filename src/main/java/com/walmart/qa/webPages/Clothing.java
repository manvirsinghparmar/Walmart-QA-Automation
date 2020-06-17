package com.walmart.qa.webPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walmart.qa.base.Base;

public class Clothing extends Base {
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	WebDriverWait wait = new WebDriverWait(driver, 30);

	public Clothing() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[alt][title='Urban Planet']")
	WebElement urbanPlanet;

	public String pageTitle() {

		String pageTitle = driver.getTitle();

		return pageTitle;

	}

	public UrbanPlanetPage clickUrbanPlanetButton() {
		
		jse.executeScript("arguments[0].scrollIntoView(true);", urbanPlanet);

		urbanPlanet.click();

		return new UrbanPlanetPage();
	}

}
