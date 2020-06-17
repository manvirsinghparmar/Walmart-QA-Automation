package com.walmart.qa.webPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.walmart.qa.base.Base;

public class ShopGroceries extends Base {

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	WebDriverWait wait = new WebDriverWait(driver, 30);

	public ShopGroceries() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".css-1k7qv8r.e1xmck041")
	WebElement shopGrocery;

	@FindBy(css = "img#logo")
	List<WebElement> walmartGroceryLogo;

	@FindBy(xpath = "//article[@title='Fruits & vegetables']")
	WebElement fruitsVegetable;

	@FindBy(css = "a#facebook-btn")
	WebElement faceBookLogo;

	@FindBy(css = ".bx-prev.disabled")
	List<WebElement> leftMovementArrow;

	@FindBy(css = ".button.add-to-cart-btn.limited-stock")
	List<WebElement> addFoodItem;

	@FindBy(css = ".plus.button-list")
	WebElement plusSignButtonOnSelectedFood;

	@FindBy(xpath = "//div[@class='item-in-cart-count']//span[@data-bind='text: $data.item.quantity()']")
	List<WebElement> itemCountInMiniCart;

	@FindBy(css = "div#rbV6rQ5>div:nth-of-type(n)")
	List<WebElement> groceryItemList;

	public String verifyPageTitle() {

		shopGrocery.click();

		wait.until(ExpectedConditions.visibilityOf(walmartGroceryLogo.get(1)));

		String pageTitleGroceryStore = driver.getTitle();

		return pageTitleGroceryStore;

	}

	public String verifyfaceBookLogoColor() {

		shopGrocery.click();

		jse.executeScript("arguments[0].scrollIntoView(true);", faceBookLogo);

		String rgbValue = faceBookLogo.getCssValue("Color");

		String color = Color.fromString(rgbValue).asHex();

		return color;

	}

	public String verifyFuntionalityOfAddingItemsToCart() {

		shopGrocery.click();

		jse.executeScript("arguments[0].scrollIntoView(true);", leftMovementArrow.get(0));

		wait.until(ExpectedConditions.visibilityOf(addFoodItem.get(0)));

		addFoodItem.get(0).click();

		wait.until(ExpectedConditions.visibilityOf(plusSignButtonOnSelectedFood));

		plusSignButtonOnSelectedFood.click();

		String itemCount = itemCountInMiniCart.get(0).getText();

		return itemCount;

	}

	public ArrayList<Point> elementSequenceOrder() {

		Point location = null;

		ArrayList<Point> pointArrayList = new ArrayList<>();

		shopGrocery.click();

		jse.executeScript("arguments[0].scrollIntoView(true);", fruitsVegetable);

		fruitsVegetable.click();

		for (int i = 0; i < groceryItemList.size(); i++) {

			location = groceryItemList.get(i).getLocation();

			pointArrayList.add(location);
		}

		return pointArrayList;

	}

}
