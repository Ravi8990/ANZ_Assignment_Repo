package com.anz.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.anz.generic.DriverFactory;
import com.anz.generic.ReadConfigFile;

public class BaseLibrary extends DriverFactory {

	public static WebDriverWait wait;

	ReadConfigFile config = new ReadConfigFile();

	/**********************************************************************************
	 ** GENERAL METHODS
	 **********************************************************************************/

	// Method to click on element
	public void clickonelement(WebElement element) {
		try {
			waitForElement(element);
			element.click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		System.out.println("Click on " + element);
	}

	// Method for implicit wait
	public long getImplicitlyWait() {
		String implicitlyWait = config.getwait();
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	// Method to wait for an element to load
	public WebElement waitForElement(WebElement element) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();
			System.out.println("===================================");
			System.out.println("Header" + element + "Displayed Successfully");
			System.out.println("===================================");
		} catch (Exception e) {
			System.out.println("===================================");
			System.out.println("Header" + element + " Not Displayed");
			System.out.println("===================================");

		}
		return element;

	}

	// Method to pass values in textbox
	public void sendKeys(WebElement SendValue, String Value) {
		waitForElement(SendValue);
		SendValue.sendKeys(Value);
	}

	// Method to close all browser instances
	public void teardownbrowser() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
			driver = null;
		}
	}
}
