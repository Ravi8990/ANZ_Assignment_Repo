package com.anz.generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import com.anz.pages.homeloanborrowercalculatorscreen.Homeloancalculatorscreen;

public class DriverFactory {

	public static WebDriver driver;
	public static Homeloancalculatorscreen HomeloancalculatorscreenPage;

	public WebDriver getDriver() {

		try {

			ReadConfigFile file = new ReadConfigFile();
			String browserName = file.getBrowser();
			String URL = file.getURL();

			switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.FIREFOX_DRIVER_DIRECTORY);
					WebDriver driver = new FirefoxDriver();
					driver.manage().window().maximize();
				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.get(URL);
				}
				break;

			case "edge":
				// code
				if (null == driver) {
					System.setProperty("webdriver.edge.driver", Constant.EDGE_DRIVER_DIRECTORY);
					driver = new EdgeDriver();
					driver.manage().window().maximize();
				}
				break;
			}

		} catch (Exception e) {
			System.out.println("unable to load browser - " + e.getMessage());
		}

		finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			HomeloancalculatorscreenPage = PageFactory.initElements(driver, Homeloancalculatorscreen.class);

		}
		return driver;
	}

}
