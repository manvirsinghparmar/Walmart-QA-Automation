package com.walmart.qa.webPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walmart.qa.base.Base;

public class UrbanPlanetPage extends Base {

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	WebDriverWait wait = new WebDriverWait(driver, 30);

	public UrbanPlanetPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[alt='Urban Planet']")
	WebElement urbanPlanetImageOnTopOfPage;

	@FindBy(css = ".button.add-to-cart-btn.available")
	List<WebElement> addDressToCartButton;

	@FindBy(css = "div#size>button:nth-of-type(2)")
	WebElement sizeOfDress;

	@FindBy(css = ".option-selected-value")
	WebElement sizeOfDressConfirmation;

	@FindBy(id = "qty-input-productQty-1VRL6OPH21RV")
	WebElement productQuantity;

	@FindBy(id = "more-btn-productQty-1VRL6OPH21RV")
	WebElement incrementButton;

	@FindBy(id = "less-btn-productQty-1VRL6OPH21RV")
	WebElement decrementButton;

	@FindBy(id = "ac-title")
	WebElement sucessFullyAddesMessage;

	public boolean verifyUrbanPlanetImageOnTopOfScreen() {

		wait.until(ExpectedConditions.visibilityOf(urbanPlanetImageOnTopOfPage));

		boolean flag = urbanPlanetImageOnTopOfPage.isDisplayed();

		return flag;

	}

	public boolean decrementButtonisNotEnabled() {

		jse.executeScript("arguments[0].scrollIntoView(true);", addDressToCartButton.get(2));

		addDressToCartButton.get(2).click();

		return !decrementButton.isEnabled();

	}

	public String verifyDressSize() {

		jse.executeScript("arguments[0].scrollIntoView(true);", addDressToCartButton.get(2));

		addDressToCartButton.get(2).click();

		wait.until(ExpectedConditions.elementToBeClickable(sizeOfDress));

		sizeOfDress.click();

		String sizeValue = sizeOfDressConfirmation.getText();

		return sizeValue;

	}

	public String verifyQty() {

		jse.executeScript("arguments[0].scrollIntoView(true);", addDressToCartButton.get(2));

		addDressToCartButton.get(2).click();

		incrementButton.click();

		String orderedProductQty = productQuantity.getAttribute("innerHTML");

		return orderedProductQty;

	}

	public String productAddedToCart() {

		jse.executeScript("arguments[0].scrollIntoView(true);", addDressToCartButton.get(2));

		System.out.println("Total elements are: " + addDressToCartButton.size());

		addDressToCartButton.get(2).click();

		sizeOfDress.click();

		incrementButton.click();

		WebElement addToCartButton = driver.findElement(By.xpath(
				"//div[@class='wgrid-3w6 wgrid-4w4 marg-l-0']//button[@class='button add-to-cart-btn available']//span[contains(text(),'Add to cart')]"));

		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

		addToCartButton.click();

		String sucessMessage = sucessFullyAddesMessage.getText();

		return sucessMessage;

	}

}
