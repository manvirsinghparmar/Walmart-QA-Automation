package com.walmart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.walmart.qa.utils.Utils;
import com.walmart.qa.utils.WebEventsListener;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	public static EventFiringWebDriver e_driver;
	public static WebEventsListener eventlistner;

	public Base() {

		prop = new Properties();

		FileInputStream file;
		try {
			file = new FileInputStream(
					"C:\\Users\\Owner\\eclipse-workspace\\WalamartWebsiteQAAutomation\\src\\main\\java\\com\\walmart\\qa\\config\\config.properties");

			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void loggersetUp() {

		logger = Logger.getLogger(Base.class);
		PropertyConfigurator.configure(
				"C:\\Users\\Owner\\eclipse-workspace\\WalamartWebsiteQAAutomation\\src\\main\\resources\\log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.INFO);

		logger.info("Inside Log Set Up");

	}

	public static void failedTestScreenShot(String testMethodName) {

		System.out.println("Failed Test ........Taking Screen Shot........");

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		File screenShotFfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFfile, new File(
					"C:\\Users\\Owner\\eclipse-workspace\\WalamartWebsiteQAAutomation\\screenShotsOfFailedTestCases\\"
							+ "_" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}

	}

	public void inialisation() {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Owner\\eclipse-workspace\\WalamartWebsiteQAAutomation\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if (browsername.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Owner\\eclipse-workspace\\WalamartWebsiteQAAutomation\\drivers\\geckodriver.exe");

			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver

		eventlistner = new WebEventsListener();
		e_driver.register(eventlistner);

		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOADOUT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
